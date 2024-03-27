package racing.infra;

import java.util.Random;

import racing.domain.CarEngine;

public class RandomCarEngine implements CarEngine {

    private final Random random;
    private final int threshold;

    public RandomCarEngine(long seed, int threshold) {
        this.threshold = threshold;
        if (seed < 0) {
            this.random = new Random();
            return;
        }
        this.random = new Random(seed);
    }

    @Override
    public boolean canMove() {
        return random.nextInt(10) > this.threshold;
    }
}
