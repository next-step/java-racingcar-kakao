package racing.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public Race(CarEngine carEngine, String text) {
        this(splitTextIntoCars(carEngine, text));
    }

    private static List<Car> splitTextIntoCars(CarEngine carEngine, String text) {
        String[] names = text.split(",");
        return Arrays.stream(names).map(name -> new Car(name, carEngine)).collect(Collectors.toList());
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> winners() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(-1);
        return cars.stream().filter(car -> car.getPosition() == maxPosition).map(Car::getName).collect(Collectors.toList());
    }
}
