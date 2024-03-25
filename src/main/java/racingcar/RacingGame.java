package racingcar;

import java.util.Collections;
import java.util.List;

public class RacingGame {
	private final int round;
	private List<Car> cars;
	public RacingGame(int round, List<Car> cars) {
		this.round = round;
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
