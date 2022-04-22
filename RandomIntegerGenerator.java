package algorithmscomparator;

import java.util.Random;

public class RandomIntegerGenerator {
    private final Random generator = new Random();

    public Integer[] getRandomArray(int count, int lowerBound, int upperBound) {
        Integer[] randomInts = new Integer[count];
        for (int i = 0; i < count; i++) {
            int currentInteger = generator.nextInt(lowerBound, upperBound+1);
            randomInts[i] = currentInteger;
        }
        return randomInts;
    }
}
