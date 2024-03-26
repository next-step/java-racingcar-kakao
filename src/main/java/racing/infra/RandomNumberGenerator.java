package racing.infra;

import java.util.Random;

import racing.domain.NumberGenerator;

public class RandomNumberGenerator implements NumberGenerator {

    private final Random random;

    public RandomNumberGenerator(long seed) {
        if (seed < 0) {
            this.random = new Random();
            return;
        }
        this.random = new Random(seed);
    }

    @Override
    public int generate() {
        return random.nextInt(10);
    }
}
