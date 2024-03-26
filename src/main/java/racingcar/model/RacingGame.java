package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingGame {

    public List<Car> cars;
    public int round;

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
            cars.get(i).checkForwardMotion(createRandomNumber());
        }
    }

    private int createRandomNumber() {
        return (int) (Math.random() * 9);
    }

    public List<String> selectWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.position == maxPosition)
                .map(car -> car.name)
                .collect(Collectors.toList());
    }

    private int getMaxPosition(){
        return cars.stream()
                .mapToInt(car -> car.position)
                .max()
                .orElseThrow(()-> new IllegalStateException("있을 수 없는 상황이다."));
    }
}
