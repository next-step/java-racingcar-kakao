package racinggame.domains;

import java.util.InputMismatchException;
import java.util.Objects;

public final class Car {
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private final String owner;

    private int offset;

    public Car(String owner, int offset) {
        validateLength(owner);
        this.owner = owner;
        this.offset = offset;
    }

    public static Car of(String owner) {
        return new Car(owner, 0);
    }

    private static void validateLength(String name) {
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new InputMismatchException("이름은 최대 다섯 글자입니다.");
        }
    }

    public void move() {
        this.offset++;
    }

    public int offset() {
        return offset;
    }

    public String owner() {
        return this.owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(owner, car.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner);
    }

    public int compareOffset(Car other) {
        return Integer.compare(this.offset, other.offset);
    }

    public boolean at(int offset) {
        return this.offset == offset;
    }
}
