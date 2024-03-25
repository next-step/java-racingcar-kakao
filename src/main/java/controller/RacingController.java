package controller;

import car.Car;
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

    public List<Car> createCars() {
        carOutputView.printCarNameMessage();
        String carNames = carInputView.getCarNameInput();
        return carInputView.getCarNames(carNames)
                .stream().map(Car::new).collect(Collectors.toList());
    }

    public int getTryNumber() {
        carOutputView.printTryNumberMessage();
        return carInputView.getNumberInput();
    }
}
