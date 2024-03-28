package strcalc;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorParserTest {

    @Test
    public void testParseDefaultDelimiter() {
        String input = "1,2;3";
        CalculatorInput calculatorInput = CalculatorParser.parseInput(input);

        assertThat(calculatorInput.getText()).isEqualTo("1,2;3");
        assertThat(calculatorInput.getDelimiter()).isEqualTo(",|;");
    }

    @Test
    public void testParseCustomDelimiter() {
        String input = "//;\n1;2;3";
        CalculatorInput calculatorInput = CalculatorParser.parseInput(input);

        assertThat(calculatorInput.getText()).isEqualTo("1;2;3");
        assertThat(calculatorInput.getDelimiter()).isEqualTo(";");
    }
}