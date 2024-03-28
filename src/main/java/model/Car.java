package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

import static java.util.Arrays.*;
import static java.util.stream.Collectors.toList;

public class Car {
    private static HashSet<String> DISTINCT_NAME_SET = new HashSet<>();
    public static final int START_SCORE = 1;
    private int score;
    private final String name;

    public Car(String name, int score) {
        validate(name);
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public static List<Car> getCar(String[] carNameList) {
        return stream(carNameList)
            .map(carName -> new Car(carName, START_SCORE))
            .collect(toList());
    }

    public void validate(String str) {
        validateCarNameLength(str);
        validateCarNameDuplicate(str);
    }

    private void validateCarNameDuplicate(String str) {
        if (DISTINCT_NAME_SET.contains(str)) {
            throw new IllegalArgumentException("동일 이름은 사용 불가능합니다.");
        }

        DISTINCT_NAME_SET.add(str);
    }

    private void validateCarNameLength(String str) {
        if (str.length() > 5) {
            throw new IllegalArgumentException("차량 이름은 5자를 넘어서는 안됩니다.");
        }
    }


    public static void updateCarScore(Car car, int num) {
        if (num > 3){
            car.score++;
        }
    }

    public static String makeCarPrint(Car car) {
        String stringBuilder = car.getName() +
            " : " +
            makeDash(car.getScore());

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

        return score == car.score && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, name);
    }
}
