package calculator;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public final class Parser {
    private static final Pattern forbiddenDelimiterPattern = Pattern.compile("\\.|\\?|\\+|\\*|\\^|\\$|\\|");
    private static final Pattern customDelimiterPattern = Pattern.compile("//(.)\n(.*)");
    private static final String customDelimiterPrefix = "//";
    private static final String defaultDelimiter = ",|:";
    private final String input;
    private final String target;
    private final String delimiter;

    private Parser(String input) {
        this.input = input;
        validateInput();
        if (!input.startsWith(customDelimiterPrefix)) {
            this.delimiter = defaultDelimiter;
            target = input;
            return;
        }
        Matcher m = getCustomMatcher();
        this.delimiter = m.group(1);
        this.target = m.group(2);
    }

    private Matcher getCustomMatcher() {
        Matcher m = customDelimiterPattern.matcher(input);
        if (!m.find()) {
            throw new InputMismatchException("커스텀 구분자로 입력 값을 판별할 수 없습니다.");
        }
        return m;
    }

    public static Parser of(String input) {
        return new Parser(input);
    }

    private void validateInput() {
        checkInputBlank();
        checkInputContainsRegex();
    }

    private void checkInputBlank() {
        Objects.requireNonNull(input);
        if (input.isBlank()) {
            throw new IllegalArgumentException("파싱 대상 문자열이 비어있습니다.");
        }
    }

    private void checkInputContainsRegex() {
        Matcher matcher = forbiddenDelimiterPattern.matcher(input);
        if (matcher.find()) {
            throw new IllegalArgumentException("입력 값에는 정규표현식 예약어를 사용할 수 없습니다.");
        }
    }

    public Numbers parse() {
        try {
            List<Integer> list = Arrays.stream(target.split(delimiter))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            return Numbers.of(list);
        } catch (NumberFormatException ex) {
            throw new InputMismatchException("파싱 대상 문자열은 숫자가 아닙니다.");
        }
    }
}
