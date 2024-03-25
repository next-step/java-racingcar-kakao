package racing;

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
}
