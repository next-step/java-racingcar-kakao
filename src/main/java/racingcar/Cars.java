package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final Dice dice = new Dice();

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars(String[] inputs) {
        this(Arrays.stream(inputs)
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    public Cars(String input) {
        this(input.split(","));
    }

    public int count() {
        return cars.size();
    }

    public void move() {
        for (Car car : cars) {
            car.move(dice.throwOnce());
        }
    }

    public List<String> decideWinner() {
        int maxScore = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow();

        return cars.stream()
                .filter(it -> it.getPosition() == maxScore)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return cars.stream()
                .map(Car::toString)
                .reduce("", (prev, next) -> prev + next + "\n")
                .trim();
    }
}
