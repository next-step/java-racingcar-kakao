package racingCar;

import java.util.Random;

public class NumberGenerator {
    public static final int NUMBER_RANGE = 9;

    public int generateNumber() {
        Random rand = new Random();
        return rand.nextInt(NUMBER_RANGE + 1);
    }
}
