package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

import static java.util.Arrays.*;
import static java.util.stream.Collectors.toList;

public class Car {
    public static final int START_SCORE = 1;
    private int position;
    private final String name;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static List<Car> getWinner(List<Car> carList) {
        int maxScore = getMaxScore(carList);

        List<Car> maxCars = carList.stream()
            .filter(car -> car.isMaxScore(maxScore))
            .collect(toList());

        return maxCars;
    }

    public static List<String> getWinnerName(List<Car> carList) {
        return getWinner(carList).stream()
            .map(car -> car.name)
            .collect(toList());
    }

    private boolean isMaxScore(int maxScore) {
        return this.position == maxScore;
    }

    private static int getMaxScore(List<Car> carList) {
        return carList.stream()
            .map(car -> car.position)
            .max(Integer::compareTo)
            .orElse(START_SCORE);
    }

    public static List<Car> getCar(String[] carNameList) {
        return stream(carNameList)
            .map(carName -> {
                return new Car(carName, START_SCORE);
            })
            .collect(toList());
    }

    public static void validate(String str) {
        String[] carNameList = str.split(",");
        HashSet<String> checker = new HashSet<>();

        for (String carName : carNameList) {
            validateCarNameLength(carName);
            checker.add(carName);
        }

        if (checker.size() != carNameList.length) {
            throw new IllegalArgumentException("동일한 차량 이름은 불가능합니다.");
        }
    }

    private static void validateCarNameLength(String str) {
        if (str.length() > 5) {
            throw new IllegalArgumentException("차량 이름은 5자를 넘어서는 안됩니다.");
        }
    }



    public static Car updatePosition(Car car, int num) {
        if (num > 3){
            car.position++;
        }
        return new Car(car.name, car.position);
    }

    public static List<Car> updateCarList(List<Car> initCarList, List<Integer> randomNumList) {
        List<Car> updatedCarList = new ArrayList<>();

        int carSize = initCarList.size();
        for (int i = 0; i < carSize; i++) {
            updatedCarList.add(updatePosition(initCarList.get(i), randomNumList.get(i)));
        }

        return updatedCarList;
    }

    public static String makeCarPrint(Car car) {
        String stringBuilder = car.name +
            " : " +
            makeDash(car.position);

        return stringBuilder;

    }

    private static String makeDash(int carScore) {
        String dash = "-";

        return dash.repeat(carScore);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;

        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name);
    }
}
