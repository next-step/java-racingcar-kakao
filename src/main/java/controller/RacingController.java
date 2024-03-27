package controller;

import model.Car;
import model.RacingGame;
import view.CarInputView;
import view.CarOutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingController {
    private final CarInputView carInputView;
    private final CarOutputView carOutputView;

    public RacingController(CarInputView carInputView,
                            CarOutputView carOutputView) {
        this.carInputView = carInputView;
        this.carOutputView = carOutputView;
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
        int tryNumber = getTryNumber();
        RacingGame racingGame = new RacingGame(createCars(), tryNumber);

        carOutputView.printResultMessage();
        for (int i = 0; i < tryNumber; i++) {
            racingGame.moveCars();
            carOutputView.printCarResult(racingGame.generateRacingMessage());
        }

        carOutputView.printWinnerMessage(racingGame);
    }

    private List<Car> createCars() {
        carOutputView.printCarNameMessage();
        String carNamesInput = carInputView.getCarNameInput();
        List<String> carNames = Arrays.asList(carNamesInput.split(","));
        return carNames.stream().map(Car::new).collect(Collectors.toList());
    }

    private int getTryNumber() {
        carOutputView.printTryNumberMessage();
        return carInputView.getNumberInput();
    }
}
