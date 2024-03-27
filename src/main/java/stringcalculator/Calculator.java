package stringcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Calculator {

    private static final String REGEX = "[,;]";
    private static final String CUSTOM_REGEX = "//(.)\\\\n(.*)";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile(CUSTOM_REGEX);


    public int calculate(final String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        final Matcher m = CUSTOM_PATTERN.matcher(text);
        if (m.find()) {
            final String customDelimiter = m.group(1);
            final String[] tokens = m.group(2).split(customDelimiter);
            return getSum(tokens);
        }
        final String[] numbers = text.split(REGEX);
        return getSum(numbers);
    }

    private Integer getSum(final String[] inputNumbers) {
        final List<Integer> numbers = Arrays.stream(inputNumbers)
                .map(Integer::parseInt).collect(Collectors.toUnmodifiableList());
        for (final Integer number : numbers) {
            checkNegative(number);
        }
        return numbers.stream()
                .reduce(0, Integer::sum);
    }

    private void checkNegative(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Negative number found: " + number);
        }
    }
}
