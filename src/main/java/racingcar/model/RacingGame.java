package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingGame {
	private final WinnerSelector winnerSelector;
	private final List<Car> cars;
	private int round;

	public RacingGame(String[] carNames, int round) {
		this.winnerSelector = new WinnerSelector();
		this.cars = generateCars(carNames);
		this.round = round;
	}

	private List<Car> generateCars(String[] carNames) {
		return Stream.of(carNames)
			.map(Car::new)
			.collect(Collectors.toList());
	}

	public List<Integer> move() {
		List<Integer> positionList = new ArrayList<>();
		for (Car car : cars) {
			positionList.add(car.moveForwardIfCan(createRandomNumber()));
		}
		this.round--;

		return positionList;
	}

	public List<String> selectWinners(List<Car> cars) {
		return this.winnerSelector.selectWinners(cars);
	}

	public int createRandomNumber() {
		return (int)(Math.random() * 9);
	}

	public int getCarsLength() {
		return this.cars.size();
	}

	public boolean isNotEnd() {
		return this.round > 0;
	}

	public List<Car> getCars() {
		return Collections.unmodifiableList(cars);
	}
}
