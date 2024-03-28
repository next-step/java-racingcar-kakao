package util;

import java.util.Random;

public class RandomNumberGenerator {
    private final static Random random = new Random();

    public int generate() {
        return random.nextInt(10);
    }
}
