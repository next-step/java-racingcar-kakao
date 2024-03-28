package caculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return 0;
        }
        return sum(toInts(split(text)));
    }

    private static boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }

    private static String[] split(String text) {

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);

        if (m.find()) {
            String customDelimiter = m.group(1) + "|,|;";
            return m.group(2).split(customDelimiter);
        }

        return text.split(",|;");
    }

    private static List<Integer> toInts(String[] values) {
        return Arrays.stream(values)
                .map(Integer::parseUnsignedInt)
                .collect(Collectors.toList());
    }


    private static int sum(List<Integer> numbers) {
        int sum = 0;

        for (int number : numbers) {
            sum += number;
        }

        return sum;
    }
}
