package racingcar.controller;

import racingcar.model.RacingGame;
import racingcar.view.InputValidator;
import racingcar.view.View;

public class RacingController {
    private RacingGame racingGame;
    private final View view;
    private final InputValidator inputValidator;

    public RacingController() {
        view = new View();
        inputValidator = new InputValidator();
    }

    public void run() {
        gameSetting();
        gameStart();
        view.displayWinners(racingGame.selectWinners());
    }

    public void gameSetting(){
        String carNames = view.displayInputCarName();
        String[] names = inputValidator.createCarsFromUserInput(carNames);
        int round = view.displayTryCount();
        racingGame = new RacingGame(names, round);
    }

    private void gameStart(){
        view.displayResult();
        int round = racingGame.getRound();
        while (round-- > 0) {
            racingGame.move();
            view.displayMoveResult(racingGame.getCars());
        }
    }
}
