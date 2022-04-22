package algorithmscomparator;

import algorithmscomparator.algorithms.*;

public class Main {

    public static void main(String[] args) {

        AlgorithmsComparer comparer = new AlgorithmsComparer();
        Integer[] inputSizes = {1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000};
        ComparableAlgorithm[] algorithms = {
                new algorithm1(),
                new algorithm2(),
                new algorithm3(),
                new algorithm4()
        };

        comparer.setup(inputSizes, algorithms);
        comparer.run();
        comparer.printResults();
    }
}
