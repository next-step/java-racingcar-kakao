package calculator;

import java.util.List;

public class NumberCalculator {

    public static final int DEFAULT_VALUE = 0;

    public int calculate(List<Integer> numbers) {
        return numbers
                .stream()
                .reduce(DEFAULT_VALUE, Integer::sum);
    }
}
