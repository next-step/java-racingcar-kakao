package racing.controller;

import java.util.List;

import racing.domain.Car;
import racing.domain.CarEngine;
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
        int round = view.promptRound();

        Race race = new Race(carFactory.fromNames(carNames));

        view.printResultHeader();

        for (int i = 0; i < round; ++i) {
            race.move();
            printResult(race);
        }

        view.printWinners(race.winners());
    }

    private void printResult(Race race) {
        List<Car> cars = race.getCars();
        for (Car car : cars) {
            view.printResult(car.getName(), car.getPosition());
        }
        view.printBlankLine();
    }
}
