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
                .map(this::validateInput).reduce(Integer::sum)
                .orElse(0);
    }

    private int validateInput(String input) {
        try {
            int number = Integer.parseInt(input);
            if (number >= 0) {
                return number;
            }
            throw new RuntimeException("0 이상의 숫자를 입력해야 합니다.");
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자만을 입력해야 합니다.");
        }
    }
}
