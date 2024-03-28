package racing.controller;

import racing.domain.Car;
import racing.domain.RacingGame;
import racing.generator.RandomNumberGenerator;
import racing.view.CarView;

import java.util.ArrayList;
import java.util.List;

public class CarController {
    private final CarView carView;

    public CarController() {
        carView = new CarView();
    }

    public void run() {
        String inputCarNames = carView.getCarNames();
        String[] carNames = inputCarNames.split(",");
        RacingGame racingGame = new RacingGame(createCarList(carNames));

        int turn = carView.getTryCount();

        carView.printResultDescription();
        for (int i = 0; i < turn; i++) {
            runOneTurn(racingGame);
        }

        List<Car> cars = racingGame.getCarList();
        int maxPosition = racingGame.getMaxPosition(cars);
        List<Car> winners = racingGame.getWinner(cars, maxPosition);

        carView.printWinner(winners);
    }

    private void runOneTurn(RacingGame racingGame) {
        racingGame.proceed();
        carView.printCarList(racingGame);

    }

    private List<Car> createCarList(String[] carNames) {
        List<Car> carList = new ArrayList<>();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        for (String carName : carNames) {
            Car car = new Car(carName, randomNumberGenerator);
            carList.add(car);
        }

        return carList;
    }
}
