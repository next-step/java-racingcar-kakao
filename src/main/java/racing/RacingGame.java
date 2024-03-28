package racing;

import java.util.*;
import java.util.stream.Collectors;

public class RacingGame {

    private final List<Car> cars;
    private final RandomStrategy randomStrategy;

    public RacingGame(List<Car> cars, RandomStrategy randomStrategy) {
        this.cars = cars;
        this.randomStrategy = randomStrategy;
    }

    public RacingGame(String carNames, RandomStrategy randomStrategy) {
        this(createCars(carNames), randomStrategy);
    }

    private static List<Car> createCars(String carNames) {
        String[] carNamesArray = carNames.split(",");
        return Arrays.stream(carNamesArray)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinners() {
        Integer maxPosition = cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .map(Car::getPosition)
                .orElseThrow(() -> new RuntimeException("unreachable"));
        return cars.stream()
                .filter(c -> c.getPosition() == maxPosition)
                .sorted(Comparator.comparing(Car::getName))
                .collect(Collectors.toList());
    }

    public void moveCars() {
        cars.forEach(car -> car.moveForward(randomStrategy));
    }
}