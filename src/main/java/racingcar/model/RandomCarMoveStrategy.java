package racingcar.model;

import java.util.Random;

public class RandomCarMoveStrategy implements CarMoveStrategy {
    private static final int MOVE_DELIMITER = 4;
    private static final int RANDOM_NUMBER_BOUND = 10;

    private final Random random;

    public RandomCarMoveStrategy() {
        this.random = new Random();
    }

    @Override
    public boolean evaluateMove() {
        return generateRandomInt() >= MOVE_DELIMITER;
    }

    private int generateRandomInt() {
        return random.nextInt(RANDOM_NUMBER_BOUND);
    }
}
