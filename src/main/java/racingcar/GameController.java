package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameController {

    private final List<Car> cars;

    public GameController(List<Car> cars) {
        this.cars = cars;
    }

    public GameController(String[] inputs) {
        this(Arrays.stream(inputs)
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    public GameController(String input) {
        this(input.split(","));
    }

    public void processOneTurn() {
        for (Car car : cars) {
            int diceResult = RacingCarDice.throwOnce();
            if (RacingCarDice.isMove(diceResult)) {
                car.move();
            }
        }
    }

    public List<String> decideWinner() {
        int max = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow();

        return cars.stream()
                .filter(it -> it.getPosition() == max)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public String makeGameBoard() {
        return cars.stream()
                .map(Car::toString)
                .reduce("", (prev, next) -> prev + next + "\n")
                .trim();
    }

    // Only for Test
    public List<Car> getCars() {
        return cars;
    }
}
