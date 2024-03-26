package org.example.calculator;

import org.example.calculator.model.Calculator;
import org.example.calculator.model.CalculatorStringUtils;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n";
    private static final String CUSTOM_OPERANDS_REGEX = "//.\n(.+)";

    @Test
    void default_delimiter_test_1() {
        Calculator calculator = new Calculator("");
        int result = calculator.calculate();
        assertThat(result).isZero();
    }

    @Test
    void default_delimiter_test_null() {
        Calculator calculator = new Calculator(null);
        int result = calculator.calculate();
        assertThat(result).isZero();
    }


    @Test
    void default_delimiter_test_2() {
        Calculator calculator = new Calculator("1,2");
        int result = calculator.calculate();
        assertThat(result).isEqualTo(3);
    }

    @Test
    void default_delimiter_test_3() {
        Calculator calculator = new Calculator("1,2,3");
        int result = calculator.calculate();
        assertThat(result).isEqualTo(6);
    }

    @Test
    void default_delimiter_test_4() {
        Calculator calculator = new Calculator("1,2:3");
        int result = calculator.calculate();
        assertThat(result).isEqualTo(6);
    }

    @Test
    void getDelimiterTest() {
        String string = "//;\n1;2";
        String delimiter = CalculatorStringUtils.extractDelimiterWithRegex(string, CUSTOM_DELIMITER_REGEX, DEFAULT_DELIMITER);
        assertThat(delimiter).isEqualTo(";");
    }

    @Test
    void getDelimiterErrorTest() {
        String string = "1;2";
        String delimiter = CalculatorStringUtils.extractDelimiterWithRegex(string, CUSTOM_DELIMITER_REGEX, DEFAULT_DELIMITER);
        assertThat(delimiter).isEqualTo(",|:");
    }

    @Test
    void getOperandsTest1() {
        String string = "//;\n1;2";
        String operands = CalculatorStringUtils.extractOperandStringWithRegex(string, CUSTOM_OPERANDS_REGEX);
        assertThat(operands).isEqualTo("1;2");
    }

    @Test
    void getOperandsTest2() {
        String string = "1,2,3";
        String operands = CalculatorStringUtils.extractOperandStringWithRegex(string, CUSTOM_OPERANDS_REGEX);
        assertThat(operands).isEqualTo("1,2,3");
    }

    @Test
    void negative_operands_test() {
        Calculator calculator = new Calculator("-1,2,3");
        assertThatThrownBy(calculator::calculate)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void calculator_test() {
        Calculator calculator = new Calculator("//'\n1'2'3");
        int result = calculator.calculate();
        assertThat(result).isEqualTo(6);
    }
}
