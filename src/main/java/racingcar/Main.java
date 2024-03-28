package racingcar;

import racingcar.view.Input;
import racingcar.view.ResultView;

public class Main {

    public static void main(String[] args) {
        RacingCarGame racingCarGame = new RacingCarGame(Input.getRacingCars());
        int count = Input.getGameCount();

        ResultView.printGameProcessTitle();
        racingCarGame.printGameBoard();
        for (int i = 0; i < count; i++) {
            racingCarGame.processOneTurn();
            racingCarGame.printGameBoard();
        }
        ResultView.printGameWinner(racingCarGame.decideWinner());
    }
}
