package racingcar;

import java.util.Random;

public class Dice {
    private static final Random random = new Random();
    public static final int BOUND = 10;

    public int throwOnce() {
        return random.nextInt(BOUND);
    }
}
