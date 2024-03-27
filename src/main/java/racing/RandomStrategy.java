package racing;

import java.util.Random;

public class RandomStrategy implements MovingStrategy {

    private final Random random = new Random();

    @Override
    public int generateNumber() {
        return random.nextInt(10);
    }
}
