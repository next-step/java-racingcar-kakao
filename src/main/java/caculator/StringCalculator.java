package caculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        return sum(toInts(split(text)));
    }


    private static String[] split(String text) {
        int CUSTOM_DELIMITER_GROUPINDEX = 1;
        int TEXT_GROUPINDEX = 2;

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);

        if (m.find()) {
            String customDelimiter = m.group(CUSTOM_DELIMITER_GROUPINDEX) + "|,|;";
            return m.group(TEXT_GROUPINDEX).split(customDelimiter);
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
