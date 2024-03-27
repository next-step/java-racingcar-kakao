package racingCar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingCar.NumberGenerator;

public class Cars {

    private static final int DEFAULT_CAR_POSITION = 0;
    private static final String CAR_NAME_DElIMITER = ",";

    private final List<Car> cars = new ArrayList<>();

    public Cars(String carNames) {
        this(Arrays.asList(carNames.split(CAR_NAME_DElIMITER)));
    }

    private Cars(List<String> carNames) {
        for (String carName : carNames) {
            Car car = new Car(carName);
            this.cars.add(car);
        }
    }

    public List<String> getCarNames() {
        return cars.stream()
            .map(Car::getName)
            .collect(Collectors.toList());
    }

    public void move(NumberGenerator generator) {
        for (Car car : cars) {
            car.move(generator.generateNumber());
        }
    }

    public List<Integer> getCarPositions() {
        return cars.stream()
            .map(Car::getPosition)
            .collect(Collectors.toList());
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();

        return cars.stream()
            .filter(car -> car.isSamePosition(maxPosition))
            .map(Car::getName)
            .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(DEFAULT_CAR_POSITION);
    }

    @Override
    public String toString() {
        return cars.stream()
            .map(Car::toString)
            .collect(Collectors.joining(System.lineSeparator()));
    }
}
