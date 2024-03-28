package racing.domain;

import java.util.*;
import java.util.stream.Collectors;

public class CarList {
    private final Map<String, Car> carHashMap;

    public CarList(List<Car> carList) {
        this.carHashMap = createCarHashMap(carList);
    }

    private Map<String, Car> createCarHashMap(List<Car> carList) {
        return carList
                .stream()
                .collect(Collectors.toMap(Car::getCarName, car->car, (x, y) -> y, LinkedHashMap::new));
    }

    public Map<String, Integer> proceed() {
        Map<String, Integer> result = new LinkedHashMap<>();

        for (Car car : getCarList()) {
            result.put(car.getCarName(), car.proceed());
        }

        return result;
    }

    public Car findByName(String name) {
        return this.carHashMap.get(name);
    }

    public List<Car> getCarList() {
        return new ArrayList<>(this.carHashMap.values());
    }

    private int getMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public List<Car> getWinner() {
        List<Car> cars = getCarList();
        final int maxPosition = getMaxPosition(cars);

        return cars
                .stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}
