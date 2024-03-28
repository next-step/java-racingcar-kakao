package racingcar;

import racingcar.view.Input;
import racingcar.view.Output;

import java.util.stream.Collectors;

public class RacingCarGame {

    public void startGame() {
        GameManager gameManager = new GameManager(Input.getRacingCars());
        int count = Input.getGameCount();

        Output.printGameProcessTitle();
        gameManager.printGameBoard();
        for (int i = 0; i < count; i++) {
            gameManager.processOneTurn();
            gameManager.printGameBoard();
        }
        Output.printGameWinner(gameManager.decideWinner().stream().map(Car::getName).collect(Collectors.toList()));
    }
}
