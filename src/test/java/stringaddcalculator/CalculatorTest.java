package stringaddcalculator;

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

    @Test
    void 쉼표_구분자를_가진_문자열_입력의_경우_올바르게_더한다() {
        Calculator calculator = new Calculator();

        assertThat(calculator.sum("1,2,3"))
                .isEqualTo(new Number(6));
    }

    @Test
    void 커스텀_구분자를_가진_문자열_입력의_경우_올바르게_더한다() {
        Calculator calculator = new Calculator();

        assertThat(calculator.sum("//m\n1m2,3"))
                .isEqualTo(new Number(6));
    }
}
