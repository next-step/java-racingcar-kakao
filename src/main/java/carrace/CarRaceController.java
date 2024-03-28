package carrace;

import carrace.domain.*;

import java.util.List;
import java.util.stream.Collectors;

public class CarRaceController {

	private final CarRaceView view;

	public CarRaceController(CarRaceView view) {
		this.view = view;
	}

	public void play() {
		CarRace carRace = initCarRace();
		Round round = initRound();
		proceedRounds(carRace, round);
		endRace(carRace);
	}

	private CarRace initCarRace() {
		return new CarRace(new CarMoveRule(new RandomNumberGenerator()), createCars(view.getCarNames()));
	}

	private List<Car> createCars(List<String> carNames) {
		return carNames.stream().map(Car::new).collect(Collectors.toUnmodifiableList());
	}

	private Round initRound() {
		return new Round(view.getCarRaceRound());
	}

	private void proceedRounds(CarRace carRace, Round round) {
		view.displayResultStartMessage();
		view.displayRoundResult(carRace.getCars());
		for (int r = 0; r < round.getValue(); r++) {
			carRace.runRound();
			view.displayRoundResult(carRace.getCars());
		}
	}

	private void endRace(CarRace carRace) {
		view.displayWinnerNames(carRace.getWinningCars()
				.stream()
				.map(Car::getName)
				.collect(Collectors.toUnmodifiableList()));
	}
}
