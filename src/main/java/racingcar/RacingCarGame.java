package racingcar;

import racingcar.view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {

    private final List<Car> cars;

    public RacingCarGame(List<Car> cars) {
        this.cars = cars;
    }

    public RacingCarGame(String[] inputs) {
        this(Arrays.stream(inputs)
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    public RacingCarGame(String input) {
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
        ResultView.printGameBoard(cars);
    }
}
