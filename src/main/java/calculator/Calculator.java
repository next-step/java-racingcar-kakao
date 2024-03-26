package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private static String SEPARATOR = ",|:";
    private static String CUSTOM_SEPARATOR_REGEX = "//(.)\n(.*)";

    public int calculate(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_SEPARATOR_REGEX).matcher(input);
        if (matcher.find()) {
            SEPARATOR += "|" + matcher.group(1);
            return add(matcher.group(2).split(SEPARATOR));
        }
        return add(input.split(SEPARATOR));
    }

    private int add(String[] numbers) {
        return Arrays.stream(numbers)
                .map(Integer::parseInt).reduce(Integer::sum)
                .orElse(0);
    }
}
