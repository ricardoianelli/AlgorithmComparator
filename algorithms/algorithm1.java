package algorithmscomparator.algorithms;


import algorithmscomparator.ComparableAlgorithm;

// Algorithm 1:
// Create a new array consisting of even numbers only. Then use nested loops to solve the problem using
// the newly created array of even numbers only.
public class algorithm1 implements ComparableAlgorithm {

    private Integer[] inputs;
    private Integer result = -1;

    @Override
    public String getResultAsString() {
        return result.toString();
    }

    @Override
    public void changeInput(Object input) {
        inputs = (Integer[]) input;
    }

    @Override
    public void run() {

        Integer[] evens = new Integer[inputs.length];

        int totalEvens = 0;
        for (Integer integer: inputs) {
            if (integer % 2 == 0) {
                evens[totalEvens] = integer;
                totalEvens++;
            }
        }

        int maxDifference = 0;
        for (int i = 0; i < totalEvens; i++) {
            int currentDifference;

            for (int j = 0; j < totalEvens; j++) {
                if (i == j || evens[i] < evens[j]) continue;

                currentDifference = evens[i] - evens[j];

                if (currentDifference > maxDifference)
                    maxDifference = currentDifference;
            }
        }

        result = maxDifference;
    }
}
