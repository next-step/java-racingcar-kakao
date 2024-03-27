package racingcar.model;

public enum CarAction {

    MOVE,
    STAND;

    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 9;
    private static final int MOVE_DELIMITER = 4;
    private static final String INVALID_INPUT_NUMBER_MESSAGE = "입력값은 0 이상 9 이하여야 합니다.";

    public static CarAction generate(final int number) {
        checkInvalidNumber(number);
        if (number >= MOVE_DELIMITER) {
            return MOVE;
        }
        return STAND;
    }

    private static void checkInvalidNumber(final int number) {
        if (number < LOWER_BOUND || number > UPPER_BOUND) {
            throw new IllegalArgumentException(INVALID_INPUT_NUMBER_MESSAGE);
        }
    }

    public boolean isMove() {
        return this == MOVE;
    }
}
