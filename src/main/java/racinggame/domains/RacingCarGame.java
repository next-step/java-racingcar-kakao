package racinggame.domains;

import racinggame.utils.RandomGenerator;

import java.util.List;

public final class RacingCarGame {
    private Cars cars;
    private RandomGenerator randomGenerator;

    public RacingCarGame(Cars cars) {
        this.cars = cars;
        this.randomGenerator = new RandomGenerator();
    }

    public RacingCarGame() {
    }

    public static RacingCarGame newInstance() {
        return new RacingCarGame();
    }

    public static RacingCarGame of(List<String> carNames) {
        return new RacingCarGame(Cars.of(carNames));
    }

    public Cars cars() {
        return this.cars;
    }

    public void processTurn() {
        cars.list().stream()
                .filter(e -> MoveChecker.check(randomGenerator.generate()))
                .forEach(Car::move);
    }

    public void showStatus() {
        cars.list()
                .forEach(e -> System.out.println(e.owner() + " : " + "-".repeat(e.offset())));
    }
}
