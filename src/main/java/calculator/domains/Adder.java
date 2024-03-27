package calculator.domains;

import java.util.List;

public class Adder {
    public static int sum(List<Integer> input) {
        return input.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
