package org.example.racinggame.controller;

import org.example.racinggame.model.Car;
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
            String positionString = getCarPositionString(cars);
            outputView.printCarPositions(positionString);
        }

        outputView.printCarPositions(getCarPositionString(cars));
        outputView.printWinners(cars.getWinners());
    }

    private String getCarPositionString(Cars cars) {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars.getCarList()) {
            sb.append(car.getName())
                    .append(" : ")
                    .append("-".repeat(car.getPosition()))
                    .append("\n");
        }
        return sb.toString();
    }

    private Cars inputStringToCars(String carNamesInputString) {
        return new Cars(carNamesInputString);
    }
}
