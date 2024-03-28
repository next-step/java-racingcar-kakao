package controller;

import model.Car;
import model.RacingGame;
import service.RacingService;
import util.RandomNumberGenerator;
import view.RacingGameView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingController {
    private final RacingGameView racingGameView;
    private final RacingService racingService;
    private final RandomNumberGenerator randomNumberGenerator;


    public RacingController(RacingGameView racingGameView,
                            RacingService racingService,
                            RandomNumberGenerator randomNumberGenerator) {
        this.racingGameView = racingGameView;
        this.racingService = racingService;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void start() {
        try {
            play();
        } catch (IllegalArgumentException e) {
            racingGameView.printErrorMessage(e.getMessage());
            start();
        }
    }

    private void play() {
        RacingGame racingGame = new RacingGame(createCars());
        int tryNumber = getTryNumber();

        racingGameView.printResultMessage();
        for (int i = 0; i < tryNumber; i++) {
            racingGame.moveCars(randomNumberGenerator);
            racingGameView.printCarResult(racingGame.getRacingCars());
        }

        racingGameView.printWinnerMessage(racingGame);
    }

    private List<Car> createCars() {
        String carNames = racingGameView.getCarNameInput();
        return racingService.extractCarNames(carNames)
                .stream().map(Car::new).collect(Collectors.toList());
    }

    private int getTryNumber() {
        return racingService.validateTryNumber(racingGameView.getNumberInput());
    }
}
