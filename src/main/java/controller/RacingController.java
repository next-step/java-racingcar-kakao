package controller;

import model.Car;
import model.RacingGame;
import service.RacingService;
import view.CarInputView;
import view.CarOutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingController {
    private final CarInputView carInputView;
    private final CarOutputView carOutputView;
    private final RacingService racingService;


    public RacingController(CarInputView carInputView,
                            CarOutputView carOutputView,
                            RacingService racingService) {
        this.carInputView = carInputView;
        this.carOutputView = carOutputView;
        this.racingService = racingService;
    }

    public void start() {
        try {
            play();
        } catch (IllegalArgumentException e) {
            carOutputView.printErrorMessage(e.getMessage());
            start();
        }
    }

    private void play() {
        RacingGame racingGame = new RacingGame(createCars());
        int tryNumber = getTryNumber();

        carOutputView.printResultMessage();
        for (int i = 0; i < tryNumber; i++) {
            racingGame.moveCars();
            carOutputView.printCarResult(racingGame.generateRacingMessage());
        }

        carOutputView.printWinnerMessage(racingGame);
    }

    private List<Car> createCars() {
        carOutputView.printCarNameMessage();
        String carNames = carInputView.getCarNameInput();
        return racingService.extractCarNames(carNames)
                .stream().map(Car::new).collect(Collectors.toList());
    }

    private int getTryNumber() {
        carOutputView.printTryNumberMessage();
        return racingService.validateTryNumber(carInputView.getNumberInput());
    }
}
