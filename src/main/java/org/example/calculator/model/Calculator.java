package org.example.calculator.model;

import java.util.Arrays;
import java.util.function.Function;

public class Calculator {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n";
    private static final String CUSTOM_OPERANDS_REGEX = "//.\n(.+)";
    private final String string;

    public Calculator(String string) {
        this.string = string == null ? "" : string;
    }

    public int calculate() {
        String delimiter = CalculatorStringUtils.extractDelimiterWithRegex(string, CUSTOM_DELIMITER_REGEX, DEFAULT_DELIMITER);
        String operandString = CalculatorStringUtils.extractOperandStringWithRegex(string, CUSTOM_OPERANDS_REGEX);
        String[] operands = splitOperandStringWithDelimiter(operandString, delimiter);

        int[] integerOperands = parseStringToIntegerAndValidate(operands);
        return Arrays.stream(integerOperands).sum();
    }

    private int[] parseStringToIntegerAndValidate(String[] operands) {
        return Arrays.stream(operands)
                .map(emptyStringToZero())
                .map(Integer::parseInt)
                .peek(this::validateNonNegativeInteger)
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private Function<String, String> emptyStringToZero() {
        return s -> s.isBlank() ? "0" : s;
    }

    private String[] splitOperandStringWithDelimiter(String operandString, String delimiter) {
        return operandString.split(delimiter);
    }

    private void validateNonNegativeInteger(Integer integer) {
        if (integer < 0) {
            throw new IllegalArgumentException(String.format("negatives not allowed: %d", integer));
        }
    }
}
