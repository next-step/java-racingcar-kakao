package org.example.racinggame.utils;

import java.util.Random;

public class RandomIntegerGenerator {

    private static final Random random = new Random();

    private RandomIntegerGenerator() {
        // utility class
    }

    public static int generateEndInclusive(int start, int end) {
        return random.nextInt(end - start + 1) + start;
    }
}
