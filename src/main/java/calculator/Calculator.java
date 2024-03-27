package calculator;

import java.util.InputMismatchException;
import java.util.Objects;

public final class Calculator {
    public static int sum(String input) {
        try {
            validate(input);
            Numbers numbers = Parser.of(input).parse();
            validate(numbers);
            return Adder.sum(numbers);
        } catch (RuntimeException ex) {
            return 0;
        }
    }

    private static void validate(String input) {
        checkNonBlank(Objects.requireNonNull(input));
    }

    private static void validate(Numbers numbers) {
        checkNegative(numbers);
    }

    private static void checkNonBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("입력 값이 존재하지 않습니다.");
        }
    }

    private static void checkNegative(Numbers numbers) {
        numbers.list().stream()
                .filter(e -> e < 0)
                .findFirst()
                .ifPresent(e -> {
                    throw new InputMismatchException("입력 값에 음수가 존재합니다.");
                });
    }
}
