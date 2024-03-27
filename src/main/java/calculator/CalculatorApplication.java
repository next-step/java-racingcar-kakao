package calculator;

import java.util.InputMismatchException;

public class CalculatorApplication {
    public static void main(String[] args) {
        validate(args);
//        Adder.sum(Parser.of(args[0]).list());
    }

    private static void validate(String[] args) {
        checkArgsLength(args);
        checkArgsNonBlank(args);
    }

    private static void checkArgsLength(String[] args) {
        if (args.length != 1) {
            throw new IllegalArgumentException("문자열 계산을 위한 인자가 주어지지 않았습니다.");
        }
    }

    private static void checkArgsNonBlank(String[] args) {
        if (args[0].isBlank()) {
            throw new InputMismatchException("입력 값이 존재하지 않습니다.");
        }
    }
}
