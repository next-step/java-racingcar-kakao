package strcalc;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CalculatorTest {
    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        int result = calculator.add("1,2,3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void testAddCommaAndColon() {
        Calculator calculator = new Calculator();
        int result = calculator.add("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void testAddEmpty() {
        Calculator calculator = new Calculator();
        int result = calculator.add("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void testMatchRegex() {
        String input = "//;\n1;2;3";
        Calculator calculator = new Calculator();
        CalculatorInput calInput = calculator.captureInputPattern(input);

        assertThat(calInput.getDelimiter()).isEqualTo(";");
        assertThat(calInput.getNumbers()).isEqualTo(List.of(1, 2, 3));
    }

    @Test
    public void testMatchRegexInvalidInput() {
        String input = "//;1;2;3";
        Calculator calculator = new Calculator();

        assertThatThrownBy(() -> calculator.captureInputPattern(input)).isInstanceOf(RuntimeException.class);
    }
}
