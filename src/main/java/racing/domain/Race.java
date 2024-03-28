package racing.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

	public void nextRound() {
        cars.forEach(Car::move);
	}

    public void forEach(Predicate predicate) {
        cars.forEach(car -> predicate.predicate(car.getName(), car.getPosition()));
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

    public interface Predicate {
        void predicate(String name, int position);
    }
}
