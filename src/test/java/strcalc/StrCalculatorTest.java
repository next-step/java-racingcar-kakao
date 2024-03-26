package strcalc;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class StrCalculatorTest {

    @Test
    public void testAdd() {
        StrCalculator calculator = new StrCalculator();
        int result = calculator.add("1,2;3", ",|;");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void testAddCalcInput() {
        StrCalculator calculator = new StrCalculator();
        CalcInput calcInput = new CalcInput("1,2;3", ",|;");
        int result = calculator.add(calcInput);
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void testCustomDelimiterInput() {
        StrCalculator calculator = new StrCalculator();
        int result = calculator.add("//a|i\n1a2i3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void testEmptyInput() {
        StrCalculator calculator = new StrCalculator();
        int result = calculator.add("", ",|;");
        assertThat(result).isEqualTo(0);
    }

    // test negative number
    @Test
    public void testNegativeNumber() {
        StrCalculator calculator = new StrCalculator();
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> calculator.add("-1,2;3", ",|;"))
                .withMessageMatching("Negative integer");
    }
}