package org.example.racinggame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> carList = new ArrayList<>();

    public Cars(String inputString) {
        String[] carNames = inputString.split(",");
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
    }

    public int getCarSize() {
        return carList.size();
    }

    public Car getCar(String carName) {
        return carList.stream()
                .filter(car -> car.getName().equals(carName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 이름의 차량이 없습니다."));
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();
        return carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("차량이 없습니다."));
    }

    public void move() {
        carList.forEach(car ->
                car.forward(RandomIntegerGenerator.generateEndInclusive(0, 9))
        );
    }

    public List<Car> getCarList() {
        return carList;
    }
}
