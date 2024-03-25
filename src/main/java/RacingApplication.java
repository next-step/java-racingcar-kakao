import car.Car;
import car.RacingResult;
import controller.RacingController;
import util.RandomNumberGenerator;
import view.CarInputView;
import view.CarOutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingApplication {
    public static void main(String[] args) {
        CarInputView carInputView = new CarInputView();
        CarOutputView carOutputView = new CarOutputView();
        RacingController racingController = new RacingController(carInputView, carOutputView);

        List<Car> cars = racingController.createCars();
        int tryNumber = racingController.getTryNumber();

        carOutputView.printResultMessage();
        for (int i = 0; i < tryNumber; i++) {
            cars.forEach(car -> car.run(RandomNumberGenerator.generate()));
            carOutputView.printCarResult(cars.stream()
                    .map(Car::generateMessage).collect(Collectors.toList()));
        }

        carOutputView.printWinnerMessage(new RacingResult(cars));
    }
}
