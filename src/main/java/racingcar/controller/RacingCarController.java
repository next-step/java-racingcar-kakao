package racingcar.controller;

import racingcar.exception.InValidInputException;
import racingcar.model.RacingCar;
import racingcar.model.RacingCars;
import racingcar.view.RacingCarView;

import java.util.List;
import java.util.stream.IntStream;

public class RacingCarController {
    RacingCarView racingCarView;

    public RacingCarController(RacingCarView racingCarView) {
        this.racingCarView = racingCarView;
    }

    public void playGame() {
        int trial = requestTrial();
        RacingCars racingCars = initializeRacingCars();

        performRacingRounds(trial, racingCars.getRacingCars());

        racingCarView.displayWinners(racingCars.findWinners());
    }

    private int requestTrial() {
        try {
            return racingCarView.requestTrial();
        } catch (InValidInputException e) {
            System.out.println(e.getMessage());
            return requestTrial();
        }
    }

    private List<String> requestCarNames() {
        try {
            return racingCarView.requestCarNames();
        } catch (InValidInputException e) {
            System.out.println(e.getMessage());
            return requestCarNames();
        }
    }

    private RacingCars initializeRacingCars() {
        List<String> carNames = requestCarNames();
        racingCarView.startGameRound();
        return new RacingCars(carNames);
    }

    private void performRacingRounds(int trial, List<RacingCar> participants) {
        IntStream.range(0, trial).forEach(i -> playGameRound(participants));
    }

    private void playGameRound(List<RacingCar> participants) {
        participants.forEach(RacingCar::move);
        racingCarView.displayRacingCarStatus(participants);
    }
}
