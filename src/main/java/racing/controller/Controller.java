package racing.controller;

import java.util.List;

import racing.domain.Car;
import racing.domain.CarEngine;
import racing.domain.Race;
import racing.view.View;

public class Controller {

    private final View view;
    private final CarEngine generator;

    public Controller(View view, CarEngine generator) {
        this.view = view;
        this.generator = generator;
    }

    public void play() {
        String carNames = view.promptCars();
        int round = view.promptRound();
        Race race = new Race(generator, carNames);

        view.printResultHeader();
        for (int i = 0; i < round; ++i) {
            race.move();
            List<Car> cars = race.getCars();
            for (Car car : cars) {
                view.printResult(car.getName(), car.getPosition());
            }
            view.printBlankLine();

        }
        view.printWinners(race.winners());
    }
}
