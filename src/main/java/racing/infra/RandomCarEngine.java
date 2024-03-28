package racing.infra;

import java.util.Random;

import racing.domain.CarEngine;

public class RandomCarEngine implements CarEngine {

    public static final int MOVE_THRESHOLD = 4;
    public static final int RANDOM_BOUND = 10;
    private final Random random;

    public RandomCarEngine() {
        this.random = new Random();
    }

    protected int generateRandomCondition() {
        return random.nextInt(RANDOM_BOUND);
    }

    @Override
    public int getSpeed() {
        if (generateRandomCondition() < MOVE_THRESHOLD) {
            return 0;
        }
        return 1;
    }
}
