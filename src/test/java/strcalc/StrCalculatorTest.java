package strcalc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class StrCalculatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2;3", "//a|i\n1a2i3"})
    public void testCustomDelimiterInput(String expression) {
        StrCalculator calculator = new StrCalculator();
        int result = calculator.add(expression);
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void testEmptyInput() {
        StrCalculator calculator = new StrCalculator();
        int result = calculator.add("");
        assertThat(result).isEqualTo(0);
    }

    // test negative number
    @Test
    public void testNegativeNumber() {
        StrCalculator calculator = new StrCalculator();
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> calculator.add("-1,2;3"))
                .withMessageMatching("Negative integer");
    }
}