package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    public String[] split(String input) {

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);

        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            return tokens;
        }

        return input.split("[,:;]");
    }
}
