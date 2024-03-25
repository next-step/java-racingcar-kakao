package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {

    public static int calculate(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        List<String> delimiters = new ArrayList<>(List.of(",", ":"));
        String source = text;
        if (text.startsWith("//")) {
            delimiters.add(text.split("\n")[0].substring(2));
            source = text.split("\n")[1];
        }

        String regex = convertDelimitersToRegex(delimiters);
        String[] tokens = source.split(regex);
        return Arrays.stream(tokens)
                     .map(Integer::parseInt)
                     .peek(Calculator::validateNegative)
                     .reduce(Integer::sum)
                     .orElse(0);
    }

    private static String convertDelimitersToRegex(List<String> delimiters) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (String delimiter : delimiters) {
            builder.append(delimiter);
        }
        builder.append("]");
        return builder.toString();
    }

    private static void validateNegative(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number should be zero or positive.");
        }
    }
}
