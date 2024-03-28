package strcalc;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class StringCalculatorTest {

    @Test
    public void testAdd() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("1,2;3", ",|;");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void testAddCalcInput() {
        StringCalculator calculator = new StringCalculator();
        CalculatorInput calculatorInput = new CalculatorInput("1,2;3", ",|;");
        int result = calculator.add(calculatorInput);
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void testCustomDelimiterInput() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("//a|i\n1a2i3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void testEmptyInput() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("", ",|;");
        assertThat(result).isEqualTo(0);
    }

    // test negative number
    @Test
    public void testNegativeNumber() {
        StringCalculator calculator = new StringCalculator();
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> calculator.add("-1,2;3", ",|;"))
                .withMessageMatching("Negative integer");
    }
}