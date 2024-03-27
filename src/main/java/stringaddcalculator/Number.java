package stringaddcalculator;

import java.util.Objects;

public class Number {
    private final int number;

    public Number(int number) {
        validateBound(number);
        this.number = number;
    }

    private void validateBound(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수가 될 수 없습니다.");
        }
    }

    public Number add(Number targetNumber) {
        return new Number(this.number + targetNumber.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
