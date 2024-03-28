package racingcar;

import java.util.Random;

public class Dice {
    private static final int BOUND = 10;
    private static final Random random = new Random();

    public int throwOnce() {
        return random.nextInt(BOUND);
    }
}
