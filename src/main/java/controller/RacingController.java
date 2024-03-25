package controller;

import car.Car;
import car.RacingResult;
import util.RandomNumberGenerator;
import view.CarInputView;
import view.CarOutputView;

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
        List<Car> cars = createCars();
        int tryNumber = getTryNumber();

        carOutputView.printResultMessage();
        for (int i = 0; i < tryNumber; i++) {
            cars.forEach(car -> car.run(RandomNumberGenerator.generate()));
            carOutputView.printCarResult(cars.stream()
                    .map(Car::generateMessage).collect(Collectors.toList()));
        }

        carOutputView.printWinnerMessage(new RacingResult(cars));
    }

    private List<Car> createCars() {
        carOutputView.printCarNameMessage();
        String carNames = carInputView.getCarNameInput();
        return carInputView.getCarNames(carNames)
                .stream().map(Car::new).collect(Collectors.toList());
    }

    private int getTryNumber() {
        carOutputView.printTryNumberMessage();
        return carInputView.getNumberInput();
    }
}
