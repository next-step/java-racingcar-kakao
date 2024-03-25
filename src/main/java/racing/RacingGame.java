package racing;

import java.util.*;
import java.util.stream.Collectors;

public class RacingGame {

    private final List<Car> cars;
    private final RandomStrategy rs;

    public RacingGame(List<Car> cars, RandomStrategy rs) {
        this.cars = cars;
        this.rs = rs;
    }

    public RacingGame(String carNames) {
        this(carNames.split(","));
    }

    public RacingGame(String[] carNames) {
        this(Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toList()));
    }
    public RacingGame(List<Car> cars) {
        this(cars, new RealRandomStrategy());
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> winners() {
        Map<Integer, List<Car>> groupByPosition = cars.stream().collect(Collectors.groupingBy(Car::getPosition));
        ArrayList<Integer> positions = new ArrayList<>(groupByPosition.keySet());
        positions.sort(Collections.reverseOrder());
        List<Car> winners = groupByPosition.get(positions.get(0));
        winners.sort(Comparator.comparing(Car::getName));
        return winners;
    }

    public void moveCars() {
        cars.forEach(car -> car.moveForward(rs));
    }
}