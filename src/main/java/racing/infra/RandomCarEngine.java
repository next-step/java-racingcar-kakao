package racing.infra;

import java.util.Random;

import racing.domain.CarEngine;

public class RandomCarEngine implements CarEngine {

    private final Random random;

    public RandomCarEngine() {
        this.random = new Random();
    }

    protected int generateRandomCondition() {
        return random.nextInt(10);
    }

    @Override
    public int getSpeed() {
        if (generateRandomCondition() < 4) {
            return 0;
        }
        return 1;
    }
}
