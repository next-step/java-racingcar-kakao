package controller;

import car.Car;
import car.RacingGame;
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
        return extractCarNames(carNames)
                .stream().map(Car::new).collect(Collectors.toList());
    }

    private List<String> extractCarNames(String input) {
        List<String> carNames = Arrays.asList(input.split(","));
        carNames.forEach(this::validateCarName);
        return carNames;
    }

    private void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    private int validateTryNumber(int tryNumber) {
        if (tryNumber < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
        return tryNumber;
    }

    private int getTryNumber() {
        carOutputView.printTryNumberMessage();
        return validateTryNumber(carInputView.getNumberInput());
    }
}
