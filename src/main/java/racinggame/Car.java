package racinggame;

import java.util.Objects;
import java.util.Random;

public class Car {
    private static final Random ENGINE = new Random();
    private static final int ENGINE_LIMIT = 10;
    private static final int FORWARDABLE = 4;
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private int offset;

    public static Car of(String owner) {
        return new Car(owner);
    }

    protected Car(String name) {
        this.name = name;
        validateOwner();
    }

    private void validateOwner() {
        checkNullOrBlank();
        checkLength();
    }

    private void checkNullOrBlank() {
        Objects.requireNonNull(name);
        if (name.isBlank()) {
            throw new IllegalArgumentException("자동차 소유주는 빈 문자열일 수 없습니다.");
        }
    }

    private void checkLength() {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 소유주는 5글자 이하여야 합니다.");
        }
    }

    public int offset() {
        return offset;
    }

    public void move() {
        if (pickEngineValue() >= FORWARDABLE) {
            offset++;
        }
    }

    protected int pickEngineValue() {
        return ENGINE.nextInt(ENGINE_LIMIT);
    }

    public String status() {
        return name + " : " + "-".repeat(offset);
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
}
