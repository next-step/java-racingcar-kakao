package calculator;

import java.util.Arrays;

public class Calculator {
    private static String SEPARATOR = ",|:";

    public int calculate(String input) {
        return Arrays.stream(input.split(SEPARATOR))
                .map(Integer::parseInt).reduce(Integer::sum)
                .orElse(0);
    }
}
