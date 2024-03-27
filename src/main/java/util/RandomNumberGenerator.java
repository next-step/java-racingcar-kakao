package util;

import java.util.Random;

public class RandomNumberGenerator {
    private static final int MAX_RANDOM_VALUE = 10;
    private static final Random random = new Random();


    public static int generate() {
        return random.nextInt(MAX_RANDOM_VALUE);
    }
}
