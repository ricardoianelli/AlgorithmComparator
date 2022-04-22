package algorithmscomparator.algorithms;


import algorithmscomparator.ComparableAlgorithm;

// Algorithm 2:
// Use a nested loop to solve the problem without creating an extra array.
public class algorithm2 implements ComparableAlgorithm {

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
        int maxDifference = 0;

        for (int i = 0; i < inputs.length; i++) {
            if (inputs[i] % 2 != 0)
                continue;

            int currentDifference;

            for (int j = 0; j < inputs.length; j++) {
                if (i == j || inputs[j] % 2 != 0 || inputs[i] < inputs[j])
                    continue;

                currentDifference = inputs[i] - inputs[j];

                if (currentDifference > maxDifference)
                    maxDifference = currentDifference;
            }
        }

        result = maxDifference;
    }
}
