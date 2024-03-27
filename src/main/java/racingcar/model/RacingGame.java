package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingGame {

    private List<Car> cars;
    private int round;

    public List<Car> getCars() {
        return cars;
    }

    public int getRound() {
        return round;
    }

    public RacingGame() {
    }

    public RacingGame(String [] carNames, int round) {
        this.cars = generateCars(carNames);
        this.round = round;
    }

    private List<Car> generateCars(String [] carNames) {
        return Stream.of(carNames)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void move() {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).decideMovement(createRandomNumber());
        }
    }

    private int createRandomNumber() {
        return (int) (Math.random() * 9);
    }

    public List<String> selectWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition(){
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(()-> new IllegalStateException("있을 수 없는 상황이다."));
    }
}
