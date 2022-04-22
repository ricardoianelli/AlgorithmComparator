package algorithmscomparator.algorithms;

import algorithmscomparator.ComparableAlgorithm;

// Algorithm 3:
// Use one loop. Find max and min of even integers. Compute max – min
public class algorithm3 implements ComparableAlgorithm {

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
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (Integer integer : inputs) {
            if (integer % 2 != 0)
                continue;

            if (integer < min)
                min = integer;
            if (integer > max)
                max = integer;
        }

        result = max - min;
    }
}
