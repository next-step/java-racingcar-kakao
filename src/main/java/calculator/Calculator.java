package calculator;

import java.util.InputMismatchException;
import java.util.Objects;

public final class Calculator {
    private Calculator() {
        throw new AssertionError("Calculator는 상태를 갖지 않는 유틸 객체입니다.");
    }

    public static int sum(String input) {
        try {
            validate(input);
            Numbers numbers = Parser.of(input).parse();
            validate(numbers);
            return numbers.list().stream()
                    .mapToInt(Integer::intValue)
                    .sum();
        } catch (NullPointerException | IllegalArgumentException ex) {
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
