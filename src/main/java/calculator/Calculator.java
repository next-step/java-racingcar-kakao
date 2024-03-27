package calculator;

import java.util.Objects;

public final class Calculator {
    public static int sum(String input) {
        try {
            validate(input);
            return Adder.sum(null);
        } catch (RuntimeException ex) {
            return 0;
        }
    }

    private static void validate(String input) {
        checkNonBlank(Objects.requireNonNull(input));
    }

    private static void checkNonBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("입력 값이 존재하지 않습니다.");
        }
    }
}
