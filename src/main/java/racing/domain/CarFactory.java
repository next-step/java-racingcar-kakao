package racing.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {

    private final CarEngine carEngine;

    public CarFactory(CarEngine carEngine) {
        this.carEngine = carEngine;
    }

    public List<Car> fromNames(String text) {
        String[] names = text.split(",");
        return Arrays.stream(names).map(this::fromName).collect(Collectors.toList());
    }

    private Car fromName(String name) {
        return new Car(name, carEngine);
    }
}
