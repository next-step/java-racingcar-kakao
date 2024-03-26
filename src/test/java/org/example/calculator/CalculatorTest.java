package org.example.calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @Test
    void default_delimiter_test_1() {
        Calculator calculator = new Calculator("");
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
        Calculator calculator = new Calculator("//;\n1;2");
        String delimiter = calculator.getDelimiter();
        assertThat(delimiter).isEqualTo(";");
    }

    @Test
    void getDelimiterErrorTest() {
        Calculator calculator = new Calculator("1;2");
        String delimiter = calculator.getDelimiter();
        assertThat(delimiter).isEqualTo(",|:");
    }

    @Test
    void getOperandsTest1() {
        Calculator calculator = new Calculator("//;\n1;2");
        String operands = calculator.getOperandString();
        assertThat(operands).isEqualTo("1;2");
    }

    @Test
    void getOperandsTest2() {
        Calculator calculator = new Calculator("1,2,3");
        String operands = calculator.getOperandString();
        assertThat(operands).isEqualTo("1,2,3");
    }

    @Test
    void negative_operands_test() {
        Calculator calculator = new Calculator("-1,2,3");
        assertThatThrownBy(calculator::calculate)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
