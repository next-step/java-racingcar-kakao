package racing_car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

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

    @Override
    public String toString() {
        return cars.stream()
                .map(Car::toString)
                .reduce("", (prev, next) -> prev + next + "\n")
                .trim();
    }
}
