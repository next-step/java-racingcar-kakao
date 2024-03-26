package strcalc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalcParser {

    private static final String DEFAULT_DELIMITER = ",|;";
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.+)\n(.+)";
    private static final Pattern regex = Pattern.compile(CUSTOM_DELIMITER_PATTERN);

    public static CalcInput parseInput(String input) {
        Matcher matcher = regex.matcher(input);
        if (matcher.find()) {
            String delimiter = matcher.group(1);
            String text = matcher.group(2);
            return new CalcInput(text, delimiter);
        }
        return new CalcInput(input, DEFAULT_DELIMITER);
    }
}