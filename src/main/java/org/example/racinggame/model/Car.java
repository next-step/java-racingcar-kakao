package org.example.racinggame.model;

import java.util.Objects;

public class Car {

    private static final int FORWARD_THRESHOLD = 4;
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    public void forward(int number) {
        if (number >= FORWARD_THRESHOLD) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    private void validateName(String name) {
        validateCarNameIsNotNullOrBlank(name);
        validateCarNameLength(name);
    }

    private void validateCarNameIsNotNullOrBlank(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름은 null이나 공백일 수 없습니다.");
        }
    }

    private void validateCarNameLength(String name) {
        if (name.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
        }
    }
}
