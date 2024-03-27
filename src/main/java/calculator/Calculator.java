package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private static final String DEFAULT_SEPARATOR = ",|:";
    private static final String CUSTOM_SEPARATOR_REGEX = "//(.)\n(.*)";

    public int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        Matcher matcher = Pattern.compile(CUSTOM_SEPARATOR_REGEX).matcher(input);
        if (matcher.find()) {
            String customSeparator = DEFAULT_SEPARATOR + "|" + matcher.group(1);
            return add(matcher.group(2).split(customSeparator));
        }
        return add(input.split(DEFAULT_SEPARATOR));
    }

    private int add(String[] numbers) {
        return Arrays.stream(numbers)
                .map(this::validateInput)
                .reduce(Integer::sum)
                .orElse(0);
    }

    private int validateInput(String input) {
        try {
            int number = Integer.parseInt(input);
            checkPositiveOrThrow(number);
            return number;
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자만을 입력해야 합니다.");
        }
    }

    private void checkPositiveOrThrow(int number) {
        if (number < 0) {
            throw new RuntimeException("0 이상의 숫자를 입력해야 합니다.");
        }
    }
}
