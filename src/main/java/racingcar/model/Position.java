package racingcar.model;

import java.util.Objects;

public class Position {

    private static final int ZERO = 0;
    private static final String POSITION_UNDER_ZERO_MESSAGE = "위치는 음수일 수 없습니다.";

    private int value;

    public Position(final int value) {
        checkInvalidPosition(value);
        this.value = value;
    }

    private void checkInvalidPosition(final int value) {
        if (value < ZERO) {
            throw new IllegalArgumentException(POSITION_UNDER_ZERO_MESSAGE);
        }
    }

    public int getValue() {
        return value;
    }

    public void moveFront() {
        value++;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
