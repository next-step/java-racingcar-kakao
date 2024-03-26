package strcalc;

import java.util.List;

public class CalculatorInput {
    private final String delimiter;
    private final List<Integer> numbers;

    public CalculatorInput(String delimiter, List<Integer> numbers) {
        this.delimiter = delimiter;
        this.numbers = numbers;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
