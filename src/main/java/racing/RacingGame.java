package racing;

import java.util.*;
import java.util.stream.Collectors;

public class RacingGame {

    private final List<Car> cars;
    private final MovingStrategy movingStrategy;

    public RacingGame(List<Car> cars, MovingStrategy movingStrategy) {
        this.cars = cars;
        this.movingStrategy = movingStrategy;
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
        this(cars, new RandomStrategy());
    }

    public List<String> getWinners() {
        Map<Integer, List<Car>> groupByPosition = cars.stream().collect(Collectors.groupingBy(Car::getPosition));
        int winnerPosition = getWinnerPosition(groupByPosition);
        List<Car> winner =  getWinnerSortedByName(groupByPosition, winnerPosition);
        return winner.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private static int getWinnerPosition(Map<Integer, List<Car>> groupByPosition) {
        List<Integer> positions = new ArrayList<>(groupByPosition.keySet());
        positions.sort(Collections.reverseOrder());
        return positions.get(0);
    }

    private static List<Car> getWinnerSortedByName(Map<Integer, List<Car>> groupByPosition, int winnerPosition) {
        List<Car> winners = groupByPosition.get(winnerPosition);
        winners.sort(Comparator.comparing(Car::getName));
        return winners;
    }

    public void moveCars() {
        cars.forEach(car -> car.moveForward(movingStrategy.generateNumber()));
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getCarsPositionInfos() {
        return cars.stream()
                .map(Car::display)
                .collect(Collectors.toList());
    }
}