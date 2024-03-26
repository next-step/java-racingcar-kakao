package strcalc;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Calculator {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String INPUT_PATTERN = "//(.+)\n(.+)";
    private static final Pattern r = Pattern.compile(INPUT_PATTERN);

    public CalculatorInput captureInputPattern(String input) {
        Matcher matcher = r.matcher(input);
        if (matcher.find()) {
            String delimiter = matcher.group(1);
            String[] numbers = matcher.group(2).split(delimiter);
            List<Integer> intNumbers = parseNumbers(numbers);
            return new CalculatorInput(delimiter, intNumbers);
        }
        throw new RuntimeException("Invalid input");
    }

    private List<Integer> parseNumbers(String[] numbers) {
        try {
            List<Integer> intNumbers = Stream.of(numbers).map(Integer::parseInt).collect(Collectors.toList());
            checkNegativeInt(intNumbers);
            return intNumbers;
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid input");
        }
    }

    private void checkNegativeInt(List<Integer> intNumbers) {
        if (intNumbers.stream().anyMatch(n -> n < 0)) {
            throw new RuntimeException("Negatives not allowed");
        }
    }

    public int add(String numbers, String delimiter) {
        if (numbers.isEmpty()) {
            return 0;
        }
        String[] numbersArray = numbers.split(delimiter);
        return sum(numbersArray);
    }

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        return add(numbers, DEFAULT_DELIMITER);
    }

    private int sum(String[] numbersArray) {
        int sum = 0;
        for (String number : numbersArray) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
