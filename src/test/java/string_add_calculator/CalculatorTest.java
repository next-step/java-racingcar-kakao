package string_add_calculator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    void sum() {
        Calculator calculator = new Calculator();

        assertThat(calculator.sum(
                List.of(
                        new Number(1),
                        new Number(2),
                        new Number(3)))
        ).isEqualTo(new Number(6));
    }
}
