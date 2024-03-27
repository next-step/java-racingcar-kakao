package strcalc;

import java.util.Arrays;

public class StrCalculator {

    public int add(String input) {
        return add(CalcParser.parseInput(input));
    }

    private int add(String text, String delimiter) {
        if (text.isEmpty()) {
            return 0;
        }
        String[] numbers = text.split(delimiter);
        return sum(numbers);
    }

    private int add(CalcInput calcInput) {
        return add(calcInput.getText(), calcInput.getDelimiter());
    }

    private int sum(String[] numbers) {
        validateInput(numbers);
        return Arrays.stream(numbers)
                .map(this::parseInt)
                .mapToInt(Integer::intValue)
                .sum();
    }

    private static void validateInput(String[] input) {
        Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .forEach(number -> {
                    if (number < 0) {
                        throw new RuntimeException("Negative integer");
                    }
                });
    }

    private int parseInt(String number) {
        int val = Integer.parseInt(number);
        if (val < 0) {
            throw new RuntimeException("Negative integer");
        }
        return val;
    }
}