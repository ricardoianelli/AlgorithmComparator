package algorithmscomparator;


import java.util.*;
import java.util.concurrent.TimeUnit;

public class AlgorithmsComparer {
    private final int HEATING_ITERATIONS = 10000;
    private Integer[] inputSizes;
    private Integer[][] inputs;
    private ComparableAlgorithm[] algorithms;
    private AlgorithmResults[] algorithmResults;
    private RandomIntegerGenerator randomGenerator;

    private class AlgorithmMeasurement {
        Integer inputSize;
        Long startTimeInNanoSeconds;
        Long stopTimeInNanoSeconds;
        String returnedValue;

        public AlgorithmMeasurement(Integer inputSize) {
            this.inputSize = inputSize;
        }

        public void setStartTime(Long startTime) {
            startTimeInNanoSeconds = startTime;
        }

        public void setStopTime(Long stopTime) {
            stopTimeInNanoSeconds = stopTime;
        }

        private Long getElapsedTimeInMicroSeconds() {
            return TimeUnit.MICROSECONDS.convert(stopTimeInNanoSeconds - startTimeInNanoSeconds, TimeUnit.NANOSECONDS);
        }

        private String getReturnedValue() {
            return returnedValue;
        }

        @Override
        public String toString() {
            return "Input Size:" + inputSize +
                    ", elapsedTime: " + getElapsedTimeInMicroSeconds() + " μs" +
                    ", returnedValue: " + getReturnedValue();
        }
    }

    private class AlgorithmResults {
        List<AlgorithmMeasurement> measurements;
        ComparableAlgorithm algorithm;

        private AlgorithmResults(ComparableAlgorithm algorithm) {
            this.algorithm = algorithm;
            measurements = new ArrayList<>();
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(algorithm.getClass().getSimpleName()).append("\n");
            for (AlgorithmMeasurement measurement : measurements) {
                sb.append(measurement.toString()).append("\n");
            }
            return sb.toString();
        }
    }

    public void setup(Integer[] inputSizes, ComparableAlgorithm[] algorithms) {
        randomGenerator = new RandomIntegerGenerator();
        this.inputSizes = inputSizes;
        this.algorithms = algorithms;

        algorithmResults = new AlgorithmResults[algorithms.length];
        generateInputs();
    }

    private void generateInputs() {
        inputs = new Integer[inputSizes.length][];

        for (int i = 0; i < inputSizes.length; i++) {
            inputs[i] = randomGenerator.getRandomArray(inputSizes[i], 0, 10000);
        }
    }

    public void run() {
        for (int i = 0; i < algorithms.length; i++) {
            ComparableAlgorithm alg = algorithms[i];
            heatAlgorithm(alg);
            AlgorithmResults result = new AlgorithmResults(alg);
            logAlgorithmProcess(alg, "Running the algorithms and collecting data...");
            for (Integer[] input : inputs) {
                Integer inputSize = input.length;
                AlgorithmMeasurement measurement = new AlgorithmMeasurement(inputSize);
                measurement.setStartTime(System.nanoTime());
                alg.changeInput(input);
                alg.run();
                measurement.returnedValue = alg.getResultAsString();
                measurement.setStopTime(System.nanoTime());
                result.measurements.add(measurement);
            }
            logAlgorithmProcess(alg, "Done!");
            algorithmResults[i] = result;
        }
    }

    // Heating is needed because the way JVM and Hotspot works. If you try to run it without heating,
    // you'll find out that the results show a sudden drop in the run time after some runs.
    // That happens because the JVM tracks code parts that are being used frequently and compiles it
    // as a part of the optimizations it makes to ensure your program will run faster.
    private void heatAlgorithm(ComparableAlgorithm algorithm) {
        logAlgorithmProcess(algorithm, "Heating algorithm to make JVM compile it...");
        Integer[] heatingInput = {1,2,3};
        algorithm.changeInput(heatingInput);
        for (int i = 0; i < HEATING_ITERATIONS; i++) {
            algorithm.run();
        }
    }

    private void logAlgorithmProcess(ComparableAlgorithm algorithm, String message) {
        System.out.println("[" + algorithm.getClass().getSimpleName() + "] " + message);
    }

    public void printResults() {
        System.out.println("------------------");
        System.out.println("---- Results ----");
        System.out.println("------------------");
        for (AlgorithmResults result : algorithmResults) {
            System.out.println(result);
        }
    }
}
