package calculator;

import java.util.List;

public final class Adder {
    public static int sum(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
