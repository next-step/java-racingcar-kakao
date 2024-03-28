package racing.controller;

import java.util.List;

import racing.domain.Car;
import racing.domain.CarFactory;
import racing.domain.Race;
import racing.view.View;

public class Controller {

    private final View view;
    private final CarFactory carFactory;

    public Controller(View view, CarFactory carFactory) {
        this.view = view;
        this.carFactory = carFactory;
    }

    public void play() {
        String carNames = view.promptCars();
        Race race = new Race(carFactory.fromCsvNames(carNames));

        int round = view.promptRound();

        view.printResultHeader();

        for (int i = 0; i < round; ++i) {
            List<Car> cars = race.nextRound();
            printResult(cars);
        }

        view.printWinners(race.getWinnersName());
    }

    private void printResult(List<Car> cars) {
        for (Car car : cars) {
            view.printResult(car.getName(), car.getPosition());
        }
        view.printBlankLine();
    }
}
