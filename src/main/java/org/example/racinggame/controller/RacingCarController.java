package org.example.racinggame.controller;

import org.example.racinggame.model.Cars;
import org.example.racinggame.view.InputView;
import org.example.racinggame.view.OutputView;

public class RacingCarController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        String carNamesInputString = inputView.getCarNamesFromUserInput();
        int tryCount = inputView.getTryCountFromUserInput();

        Cars cars = inputStringToCars(carNamesInputString);

        outputView.printResult();
        for (int i = 0; i < tryCount; i++) {
            cars.move();
            printCarPositions(cars);
        }

        printCarPositions(cars);
        outputView.printWinners(cars.getWinners());
    }

    private void printCarPositions(Cars cars) {
        cars.getCarList()
                .forEach(car -> outputView.printCarPosition(car.getName(), car.getPosition()));
        outputView.newLine();
    }

    private Cars inputStringToCars(String carNamesInputString) {
        return new Cars(carNamesInputString);
    }
}
