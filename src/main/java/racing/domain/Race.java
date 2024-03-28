package racing.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

	public List<Car> nextRound() {
        cars.forEach(Car::move);
        return Collections.unmodifiableList(cars);
	}

    public List<String> getWinnersName() {
        int maxPosition = cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(0);
        return cars.stream()
            .filter(car -> car.locates(maxPosition))
            .map(Car::getName)
            .collect(Collectors.toList());
    }
}
