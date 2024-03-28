package racing;

import java.util.Random;

public class RealRandomStrategy implements RandomStrategy {

    private final Random random = new Random();

    @Override
    public int generateRandomNumber() {
        return random.nextInt(10);
    }
}
