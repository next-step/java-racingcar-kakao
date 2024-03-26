package org.example.calculator.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorStringUtils {

    private CalculatorStringUtils() {
        // utility class
    }

    public static String extractDelimiterWithRegex(String string, String regex, String defaultDelimiter) {
        Matcher m = Pattern.compile(regex).matcher(string);
        if (m.find()) {
            return m.group(1);
        }
        return defaultDelimiter;
    }

    public static String extractOperandStringWithRegex(String string, String regex) {
        Matcher m = Pattern.compile(regex).matcher(string);
        if (m.find()) {
            return m.group(1);
        }
        return string;
    }
}
