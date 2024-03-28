package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class WinnerSelector {
	public List<String> selectWinners(List<Car> cars) {
		int maxPosition = getMaxPosition(cars);

		return cars.stream()
			.filter(car -> car.getPosition() == maxPosition)
			.map(Car::getName)
			.collect(Collectors.toList());
	}

	private int getMaxPosition(List<Car> cars) {
		return cars.stream()
			.mapToInt(Car::getPosition)
			.max()
			.orElseThrow(() -> new IllegalStateException("있을 수 없는 상황이다."));
	}
}
