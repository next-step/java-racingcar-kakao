package racing;

import java.util.*;
import java.util.stream.Collectors;

public class RacingGame {

    private final List<Car> cars;
    private final RandomStrategy randomStrategy;

    public RacingGame(List<Car> cars, RandomStrategy randomStrategy) {
        this.cars = cars;
        this.randomStrategy = randomStrategy;
    }

    public RacingGame(String carNames, RandomStrategy randomStrategy) {
        this(createCars(carNames), randomStrategy);
    }

    private static List<Car> createCars(String carNames) {
        String[] carNamesArray = carNames.split(",");
        return Arrays.stream(carNamesArray)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinners() {
        Map<Integer, List<Car>> groupByPosition = cars.stream().collect(Collectors.groupingBy(Car::getPosition));
        int winnerPosition = getWinnerPosition(groupByPosition);
        return getWinnerSortedByName(groupByPosition, winnerPosition);
    }

    private static List<Car> getWinnerSortedByName(Map<Integer, List<Car>> groupByPosition, int winnerPosition) {
        List<Car> winners = groupByPosition.get(winnerPosition);
        winners.sort(Comparator.comparing(Car::getName));
        return winners;
    }

    private static int getWinnerPosition(Map<Integer, List<Car>> groupByPosition) {
        ArrayList<Integer> positions = new ArrayList<>(groupByPosition.keySet());
        positions.sort(Collections.reverseOrder());
        return positions.get(0);
    }

    public void moveCars() {
        cars.forEach(car -> car.moveForward(randomStrategy));
    }
}