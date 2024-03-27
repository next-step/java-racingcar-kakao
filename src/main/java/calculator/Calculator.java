package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public static int calculate(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        List<String> delimiters = new ArrayList<>(List.of(",", ":"));
        String source = text;

        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (matcher.find()) {
            delimiters.add(matcher.group(1));
            source = matcher.group(2);
        }

        return doCalculate(source, delimiters);
    }

    private static String convertDelimitersToRegex(List<String> delimiters) {
        return String.join("|", delimiters);
    }

    private static int doCalculate(String source, List<String> delimiters) {
        String regex = convertDelimitersToRegex(delimiters);
        String[] tokens = source.split(regex);
        return Arrays.stream(tokens)
                     .map(Calculator::parseAndValidate)
                     .reduce(Integer::sum)
                     .orElse(0);
    }

    private static int parseAndValidate(String text) {
        int number = Integer.parseInt(text);
        if (number < 0) {
            throw new IllegalArgumentException("Number should be zero or positive.");
        }
        return number;
    }
}
