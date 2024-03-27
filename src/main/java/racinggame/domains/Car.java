package racinggame.domains;

import java.util.InputMismatchException;
import java.util.Objects;

public final class Car implements Comparable<Car> {
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
        if (name.length() > 5) {
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
    public int compareTo(Car o) {
        return Integer.compare(this.offset, o.offset);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return offset == car.offset && Objects.equals(owner, car.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, offset);
    }
}
