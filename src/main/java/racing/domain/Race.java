package racing.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Race {

    private final NumberGenerator generator;
    private final List<Car> cars;

    public Race(NumberGenerator generator, List<Car> cars) {
        this.generator = generator;
        this.cars = cars;
    }

    public Race(NumberGenerator generator, String text) {
        this(generator, splitTextIntoCars(text));
    }

    private static List<Car> splitTextIntoCars(String text) {
        String[] names = text.split(",");
        return Arrays.stream(names).map(Car::new).collect(Collectors.toList());
    }

    public void move() {
        cars.forEach(car -> car.move(generator.generate()));
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> winners() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(-1);
        return cars.stream().filter(car -> car.getPosition() == maxPosition).map(Car::getName).collect(Collectors.toList());
    }
}
