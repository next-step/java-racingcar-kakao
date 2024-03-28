package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.view.RacingGameView;

public class RacingGameApplication {

    public static void main(String[] args) {
        RacingGameView racingGameView = new RacingGameView();
        RacingGameController racingGameController = new RacingGameController(racingGameView);

        racingGameController.playGame();
    }
}
