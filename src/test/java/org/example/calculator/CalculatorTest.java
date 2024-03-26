package org.example.calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}
