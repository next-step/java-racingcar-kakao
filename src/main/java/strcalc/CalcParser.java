package strcalc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalcParser {

    private static final String DEFAULT_DELIMITER = ",|;";
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.+)\n(.+)";
    private static final int DELIMITER_INDEX = 1;
    private static final int TEXT_INDEX = 2;

    public static CalcInput parseInput(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(input);
        if (matcher.find()) {
            String delimiter = matcher.group(DELIMITER_INDEX);
            String text = matcher.group(TEXT_INDEX);
            return new CalcInput(text, delimiter);
        }
        return new CalcInput(input, DEFAULT_DELIMITER);
    }
}