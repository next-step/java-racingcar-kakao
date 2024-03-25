package racing;

import java.util.List;

public class Race {

    private final NumberGenerator generator;
    private final List<Car> cars;

    public Race(NumberGenerator generator, List<Car> cars) {
        this.generator = generator;
        this.cars = cars;
    }

    public void move() {
        cars.forEach(car -> car.move(generator.generate()));
    }
}
