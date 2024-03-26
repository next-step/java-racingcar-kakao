package org.example.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n";
    private static final String CUSTOM_OPERANDS_REGEX = "//.\n(.+)";
    private final String string;

    public Calculator(String string) {
        this.string = string;
    }

    public int calculate() {
        String delimiter = getDelimiter();
        String[] operands = getOperandString().split(delimiter);
        int result = 0;
        for (String operand : operands) {
            result += getParsedInt(operand);
        }
        return result;
    }

    private static int getParsedInt(String operand) {
        try {
            return Integer.parseInt(operand);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public String getDelimiter() {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(this.string);
        if (m.find()) {
            return m.group(1);
        }
        return DEFAULT_DELIMITER;
    }

    public String getOperandString() {
        Matcher m = Pattern.compile(CUSTOM_OPERANDS_REGEX).matcher(this.string);
        if (m.find()) {
            return m.group(1);
        }
        return this.string;
    }
}
