package org.example;

import java.util.Random;

public class RandomIntegerGenerator {

    private static final Random random = new Random();

    public static int generateEndInclusive(int start, int end) {
        return random.nextInt(end - start + 1) + start;
    }
}
