package racingcar;

import java.util.Collections;
import java.util.List;

public class Cars {
	private List<Car> cars;
	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public List<Car> findWinner() {
		Collections.sort(cars);
		Car winner = cars.get(0);
		return cars.stream()
			.filter(car -> winner.compareTo(car) == 0)
			.toList();
	}
}
