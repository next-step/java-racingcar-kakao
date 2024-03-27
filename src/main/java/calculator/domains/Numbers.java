package calculator.domains;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Numbers {
    private static final Pattern defaultInputFormatPattern = Pattern.compile("//(.)\n(.*)");
    private static final Pattern forbiddenDelimiterPattern = Pattern.compile("\\.|\\^|\\$|\\*|\\+|\\?|\\|");

    private final List<Integer> numbers;

    private Numbers(String delimiter, String targetString) {
        try {
            numbers = Arrays.stream(targetString.split(delimiter))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new RuntimeException("문자를 입력할 수 없습니다.");
        }
        validateNegatives();
    }

    private void validateNegatives() {
        numbers.stream().filter(i -> i < 0)
                .findAny()
                .ifPresent((number) -> {
                    throw new RuntimeException("음수를 입력할 수 없습니다.");
                });
    }

    public static Numbers of(String input) {
        validateRegex(input);
        if (!input.startsWith("//")) {
            return new Numbers(",|:", input);
        }
        Matcher m = defaultInputFormatPattern.matcher(input);
        if (!m.find()) {
            throw new RuntimeException("커스텀 구분자로 입력 값을 판별할 수 없습니다.");
        }
        return new Numbers(m.group(1), m.group(2));
    }

    private static void validateRegex(String input) {
        Matcher m = forbiddenDelimiterPattern.matcher(input);
        if (m.find()) {
            throw new RuntimeException("정규표현식 예약어를 사용할 수 없습니다.");
        }
    }

    public List<Integer> find() {
        return numbers;
    }
}
