package calculator;

import java.util.Objects;

public class StringCalculator {
    public static final int DEFAULT_VALUE = 0;
    private static final StringParser stringParser = new StringParser();

    public int calculate(String numberSequence) {
        if (Objects.isNull(numberSequence) || numberSequence.isEmpty()) {
            return DEFAULT_VALUE;
        }

        return NumberCalculator.calculate(stringParser.parse(numberSequence));
    }
}
