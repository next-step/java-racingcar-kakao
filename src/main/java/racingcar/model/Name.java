package racingcar.model;

public class Name {

    private static final String INVALID_LENGTH_MESSAGE = "이름의 길이는 5자 이하여야 합니다.";
    private static final String NOT_ZERO_LENGTH_MESSAGE = "이름의 길이는 0이 될 수 없습니다.";
    private static final String NO_SPACE_AT_EDGE_MESSAGE = "이름 앞뒤에 띄어쓰기가 있을 수 없습니다.";
    private static final int MAX_NAME_LENGTH = 5;
    private static final char SINGLE_SPACE = ' ';
    private static final int ZERO = 0;
    private static final int ONE = 1;

    private final String value;

    public Name(final String inputName) {
        checkEmptyName(inputName);
        checkMaxNameLength(inputName);
        checkSpaceAtEdge(inputName);
        this.value = inputName;
    }

    private void checkSpaceAtEdge(final String inputName) {
        if (inputName.charAt(inputName.length() - ONE) == SINGLE_SPACE || inputName.charAt(ZERO) == SINGLE_SPACE) {
            throw new IllegalArgumentException(NO_SPACE_AT_EDGE_MESSAGE);
        }
    }

    private void checkEmptyName(final String inputName) {
        if (inputName == null || inputName.isEmpty()) {
            throw new IllegalArgumentException(NOT_ZERO_LENGTH_MESSAGE);
        }
    }

    private void checkMaxNameLength(final String inputName) {
        if (inputName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_LENGTH_MESSAGE);
        }
    }

    public String getValue() {
        return value;
    }
}
