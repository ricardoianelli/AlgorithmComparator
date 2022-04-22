package algorithmscomparator.algorithms;

import algorithmscomparator.ComparableAlgorithm;

import java.util.Arrays;
import java.util.List;

// Algorithm 4:
// Use Streams to find the max and min. Compute max – min
public class algorithm4 implements ComparableAlgorithm {

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

        List<Integer> evenSorted = Arrays.stream(inputs)
                .filter(integer -> integer % 2 == 0)
                .sorted(Integer::compareTo).toList();

        result = evenSorted.get(evenSorted.size()-1) - evenSorted.get(0);
    }
}
