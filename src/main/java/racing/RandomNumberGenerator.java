package racing;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private final Random random;

    public RandomNumberGenerator(int seed) {
        this.random = new Random(seed);
    }

    @Override
    public int generate() {
        return random.nextInt(10);
    }
}
