package racingcar.controller;

import java.util.List;
import racingcar.exception.InValidInputException;
import racingcar.model.RacingCar;
import racingcar.model.RacingCars;
import racingcar.view.RacingCarView;

public class RacingCarController {

    RacingCars racingCars;
    RacingCarView racingCarView;

    public RacingCarController(RacingCarView racingCarView) {
        this.racingCarView = racingCarView;
        this.racingCars = new RacingCars(requestCarNames());
    }

    public void playGame() {
        int trial = racingCarView.requestTrial();
        List<RacingCar> participants = racingCars.getRacingCars();

        racingCarView.startGameRound();

        for (int i = 0; i < trial; i++) {
            playGameRound(participants);
        }

        racingCarView.displayWinners(racingCars.findWinners());
    }

    private void playGameRound(List<RacingCar> participants) {
        for (RacingCar racingCar : participants) {
            racingCar.move();
        }
        racingCarView.displayRacingCarStatus(participants);
    }

    private List<String> requestCarNames() {
        while (true) {
            try {
                return racingCarView.requestCarNames();
            } catch (InValidInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
