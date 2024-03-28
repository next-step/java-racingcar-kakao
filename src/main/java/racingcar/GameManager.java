package racingcar;

import racingcar.view.Output;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameManager {

    private final List<Car> cars;

    public GameManager(List<Car> cars) {
        this.cars = cars;
    }

    public GameManager(String[] inputs) {
        this(Arrays.stream(inputs)
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    public GameManager(String input) {
        this(input.split(","));
    }

    public void processOneTurn() {
        for (Car car : cars) {
            int diceResult = RacingCarDice.throwOnce();
            car.moveWithDiceNum(diceResult);
        }
    }

    public List<Car> decideWinner() {
        int max = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow();

        return cars.stream()
                .filter(it -> it.getPosition() == max)
                .collect(Collectors.toList());
    }

    public void printGameBoard() {
        cars.forEach(car -> Output.printCarProcessLine(car.getName(), car.getPosition()));
        System.out.println();
    }
}
