package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.view.RacingCarView;

public class RacingCarApplication {

    public static void main(String[] args) {
        RacingCarView racingCarView = new RacingCarView();
        RacingCarController racingCarController = new RacingCarController(racingCarView);

        racingCarController.playGame();
    }
}
