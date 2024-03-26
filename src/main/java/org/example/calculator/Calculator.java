package org.example.calculator;

public class Calculator {

    private static final String DEFAULT_DELIMITER = ",|:";
    private final String string;

    public Calculator(String string) {
        this.string = string;
    }

    public int calculate() {
        String[] operands = string.split(DEFAULT_DELIMITER);
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
}
