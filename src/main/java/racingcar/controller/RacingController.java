package racingcar.controller;

import java.util.ArrayList;
import java.util.List;

import racingcar.model.RacingGame;
import racingcar.view.View;

public class RacingController {
	private RacingGame racingGame;
	private final View view;

	public RacingController() {
		this.view = new View();
	}

	public void run() {
		gameSetting();
		List<List<Integer>> gameResult = gameStart();

		this.view.displayResult(gameResult, this.racingGame.getCars());
		this.view.displayWinners(this.racingGame.selectWinners(racingGame.getCars()));
	}

	public void gameSetting() {
		String carNames = this.view.requestInputCarName();
		String[] names = createCarNamesFromUserInput(carNames);

		int round = this.view.requestInputTryCount();

		this.racingGame = new RacingGame(names, round);
	}

	private List<List<Integer>> gameStart() {
		List<List<Integer>> gameResult = new ArrayList<>();

		this.view.displayStart();
		while (racingGame.isNotEnd()) {
			gameResult.add(this.racingGame.move());
		}

		return gameResult;
	}

	public String[] createCarNamesFromUserInput(String input) {
		return input.split(",");
	}

}
