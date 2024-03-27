package carrace.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarRace {

	private final CarMoveRule carMoveRule;
	private final List<Car> cars;

	public CarRace(CarMoveRule carMoveRule, List<Car> cars) {
		this.carMoveRule = carMoveRule;
		this.cars = cars;
		validateDuplicateNames();
	}

	private void validateDuplicateNames() {
		if (cars.size() != cars.stream().distinct().count()) {
			throw new IllegalArgumentException("중복된 이름이 존재합니다.");
		}
	}

	public void runRound() {
		for (Car car : cars) {
			moveIfMovable(car);
		}
	}

	private void moveIfMovable(Car car) {
		if (carMoveRule.isMovable()) {
			car.moveForward();
		}
	}

	public List<Car> getWinningCars() {
		int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElseThrow();
        return cars.stream().filter(car -> car.getPosition() == maxPosition).collect(Collectors.toUnmodifiableList());
	}

	public List<Car> getCars() {
		return Collections.unmodifiableList(this.cars);
	}
}
