package racingcar.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final String SPLIT_REGEX = ",";
    private static final String INVALID_CARS_STATE_MESSAGE = "올바르지 않은 자동차 구성입니다.";

    private final List<Car> values;

    public Cars(final String nameInput) {
        this.values = Arrays.stream(nameInput.split(SPLIT_REGEX))
                .map(Car::makeNewCar)
                .collect(Collectors.toUnmodifiableList());
    }

    public void step(final CarMoveStrategy carMoveStrategy) {
        for (final Car car : values) {
            moveOrStandCar(carMoveStrategy, car);
        }
    }

    private void moveOrStandCar(final CarMoveStrategy carMoveStrategy, final Car car) {
        if (carMoveStrategy.evaluateMove()) {
            car.move();
        }
    }

    public Winners getWinners() {
        Car maxPositionCar = values.stream()
                .max(Comparator.comparing(Car::getPosition))
                .orElseThrow(() -> new IllegalArgumentException(INVALID_CARS_STATE_MESSAGE));

        return new Winners(
                values.stream()
                        .filter(c -> c.getPosition().isAt(maxPositionCar.getPosition()))
                        .map(Car::getName)
                        .collect(Collectors.toUnmodifiableList())
        );
    }

    public List<Car> getValues() {
        return values;
    }
}
