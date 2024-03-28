package racingcar.model;

import java.util.List;

public class RacingGame {

    private final Cars cars;
    private final CarMoveStrategy carMoveStrategy;
    private StepCount stepCount;

    public RacingGame(final String inputNames, final CarMoveStrategy carMoveStrategy, final int inputCount) {
        this.cars = new Cars(inputNames);
        this.carMoveStrategy = carMoveStrategy;
        this.stepCount = new StepCount(inputCount);
    }

    public void play() {
        stepCount = stepCount.decrease();
        cars.step(carMoveStrategy);
    }

    public boolean isEnd() {
        return stepCount.isZero();
    }

    public List<Car> getCars() {
        return cars.getValues();
    }

    public List<String> getWinnerNames() {
        return cars.getWinners().getNames();
    }
}
