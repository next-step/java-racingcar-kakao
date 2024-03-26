package org.example.calculator;

import java.util.Arrays;
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
        String operandString = getOperandString();
        String[] operands = operandString.split(delimiter);

        return Arrays.stream(operands)
                .map(this::getParsedInt)
                .reduce(Integer::sum)
                .orElse(0);
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

    private int getParsedInt(String operand) {
        try {
            return Integer.parseInt(operand);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
