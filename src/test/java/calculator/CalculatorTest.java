package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void zero() {
        int sum = Calculator.calculate("");

        assertThat(sum).isZero();
    }

    @Test
    void zeroByNull() {
        int sum = Calculator.calculate(null);

        assertThat(sum).isZero();
    }

    @Test
    void one() {
        int sum = Calculator.calculate("1");

        assertThat(sum).isOne();
    }

    @Test
    void splitByComma() {
        int sum = Calculator.calculate("1,2");

        assertThat(sum).isEqualTo(3);
    }

    @Test
    void splitByColon() {
        int sum = Calculator.calculate("1:2");

        assertThat(sum).isEqualTo(3);
    }

    @Test
    void splitCustom() {
        int sum = Calculator.calculate("//;\n1;2");

        assertThat(sum).isEqualTo(3);
    }

    @Test
    void calculateMultiple() {
        int sum = Calculator.calculate("//;\n1;2;3,4:5");

        assertThat(sum).isEqualTo(15);
    }

    @Test
    void negative() {
        assertThatThrownBy(() -> Calculator.calculate("//;\n-1;2"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void notNumber() {
        assertThatThrownBy(() -> Calculator.calculate("//;\naa-1;2"))
                .isInstanceOf(RuntimeException.class);
    }
}
