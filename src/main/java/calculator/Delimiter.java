package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Delimiter {
    private static final Pattern CUSTOM_OPERATOR_REGEX = Pattern.compile("//(.)\\n*");
    private final List<String> delimiterSet;

    public Delimiter(String[] delimiters) {
        this();
        delimiterSet.addAll(Arrays.asList(delimiters));
    }

    public Delimiter() {
        delimiterSet = new ArrayList<>();
        delimiterSet.add(",");
        delimiterSet.add(";");
    }

    public String findCustomOperator(String expression) {
        Matcher m = CUSTOM_OPERATOR_REGEX.matcher(expression);
        if (m.find()) {
            String customDelimiter = m.group(1);
            delimiterSet.add(customDelimiter);
            return expression.substring(5);
        }

        return expression;
    }

    public String getDelimiter() {
        return "[" + String.join("", delimiterSet) + "]";
    }

    public boolean contains(String token) {
        return delimiterSet.contains(token);
    }

    public List<Integer> split(String expression) {
        String delimiters = getDelimiter();
        List<String> numberList = Arrays.asList(expression.split(delimiters));

        return numberList.stream().map(Integer::parseInt).collect(Collectors.toList());
    }
}
