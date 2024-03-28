package racing.generator;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator{
    private final int MAX_VALUE = 10;
    private final Random random;

    public RandomNumberGenerator() {
        this.random = new Random();
    }

    @Override
    public int generate() {
        return Math.abs(random.nextInt()) % MAX_VALUE;
    }
}
