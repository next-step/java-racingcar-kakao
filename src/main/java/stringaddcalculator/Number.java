package stringaddcalculator;

import java.util.Objects;

public class Number {
    private final int number;

    public Number(int number) {
        validate(number);
        this.number = number;
    }

    public Number(String number) {
        this(Integer.parseInt(boundNumber(number)));
    }

    private static String boundNumber(String number) {
        if (number == null || number.isEmpty()) {
            number = "0";
        }
        return number;
    }

    private void validate(int number) {
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
