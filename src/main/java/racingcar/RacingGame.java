package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import racingcar.dto.CarState;

public class RacingGame {

	private List<Car> cars;
	private int rounds;
	private final RacingGameUI ui;
	private final ProceedLogic logic;
	private final NumberGenerator numberGenerator;

	public RacingGame(RacingGameUI ui, NumberGenerator numberGenerator) {
		this.ui = ui;
		this.cars = new ArrayList<>();
		this.numberGenerator = numberGenerator;
		this.logic = new ProceedLogic(this.numberGenerator);
	}

	public void play() {
		initialize();

		ui.printResultHeader();
		for (int i = 0; i < rounds; i++) {
			playRound();
			ui.printCarStates(cars.stream().map(Car::getState).toList());
		}

		ui.printWinners(this.findWinner());
	}

	private void playRound() {
		cars.stream()
			.filter(car -> logic.askProceed())
			.forEach(Car::proceed);
	}

	private void initialize() {
		boolean validationPass = false;
		List<String> carNameList = null;
		while (!validationPass) {
			String carNames = ui.getCarNames();
			carNameList = Arrays.stream(carNames.split(",")).map(String::trim).toList();
			validationPass = validateCarNames(carNameList);
		}
		// validtion - 5글자이하, 중복

		for (String name : carNameList) {
			cars.add(new Car(name));
		}
		validationPass = false;
		String input = "";
		while(!validationPass){
			input = ui.getRounds();
			validationPass = validateRounds(input);
		}
		//validation - 숫자인지
		rounds = Integer.parseInt(input);
	}

	private boolean validateRounds(String input) {
		String trimmedString = input.trim();
		if (trimmedString.isEmpty()) {
			ui.printError(ErrorType.EMPTY_ROUND);
			return false;
		}
		if (trimmedString.length() > 5) {
			ui.printError(ErrorType.TOO_LONG_ROUND);
			return false;
		}
		if (!Arrays.stream(trimmedString.split(""))
			.filter(s -> !Character.isDigit(s.charAt(0)))
			.toList().isEmpty()){
			ui.printError(ErrorType.NON_NUMERICAL_ROUND);
			return false;
		}
		return true;
	}

	private boolean validateCarNames(List<String> carNameList) {
		if (carNameList.isEmpty() || !carNameList.stream().filter(String::isEmpty).toList().isEmpty()) {
			ui.printError(ErrorType.EMPTY_CAR_NAME);
			return false;
		}
		if (!carNameList.stream().filter(name -> name.length() > 5).toList().isEmpty()) {
			ui.printError(ErrorType.TOO_LONG_CAR_NAME);
			return false;
		}

		Set<String> uniqueName = new HashSet<>(carNameList);
		if (uniqueName.size() != carNameList.size()) {
			ui.printError(ErrorType.DUPLICATED_CAR_NAME);
			return false;
		}

		return true;
	}

	private List<CarState> findWinner() {
		Collections.sort(cars);
		Car winner = cars.get(0);
		return cars.stream()
			.filter(car -> winner.compareTo(car) == 0)
			.map(Car::getState)
			.toList();
	}
}
