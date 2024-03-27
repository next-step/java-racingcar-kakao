package racingcar;

import racingcar.view.Input;
import racingcar.view.Output;

public class RacingCarGame {

    public void startGame() {
        GameController gameController = new GameController(Input.getRacingCars());
        int count = Input.getGameCount();

        Output.printGameProcessTitle();
        Output.printGameProcessResult(gameController.makeGameBoard());
        for (int i = 0; i < count; i++) {
            gameController.processOneTurn();
            Output.printGameProcessResult(gameController.makeGameBoard());
        }
        Output.printGameWinner(gameController.decideWinner());
    }
}
