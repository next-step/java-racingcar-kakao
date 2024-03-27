package calculator;

public final class Adder {
    public static int sum(Numbers numbers) {
        return numbers.list().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
