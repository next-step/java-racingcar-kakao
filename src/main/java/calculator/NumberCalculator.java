package calculator;

import java.util.List;

public class NumberCalculator {

    public static int calculate(List<Integer> numbers) {
        return numbers
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
