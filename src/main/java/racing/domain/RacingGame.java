package racing.domain;

import java.util.*;
import java.util.stream.Collectors;

public class RacingGame {
    Map<String, Car> carHashMap;

    public RacingGame(List<Car> carList) {
        this.carHashMap = createCarHashMap(carList);
    }

    private Map<String, Car> createCarHashMap(List<Car> carList) {
        return carList
                .stream()
                .collect(Collectors.toMap(Car::getCarName, car->car, (x, y) -> y, LinkedHashMap::new));
    }

    public void proceed() {
        for (Car car : getCarList()) {
            car.proceed();
        }
    }

    public Car findByName(String name) {
        return this.carHashMap.get(name);
    }

    public List<Car> getCarList() {
        return new ArrayList<>(this.carHashMap.values());
    }

    public int getMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public List<Car> getWinner(List<Car> cars, int maxPosition) {
        return cars
                .stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}
