package strcalc;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalcParserTest {

    @Test
    public void testParseDefaultDelimiter() {
        String input = "1,2;3";
        CalcInput calcInput = CalcParser.parseInput(input);

        assertThat(calcInput.getText()).isEqualTo("1,2;3");
        assertThat(calcInput.getDelimiter()).isEqualTo(",|;");
    }

    @Test
    public void testParseCustomDelimiter() {
        String input = "//;\n1;2;3";
        CalcInput calcInput = CalcParser.parseInput(input);

        assertThat(calcInput.getText()).isEqualTo("1;2;3");
        assertThat(calcInput.getDelimiter()).isEqualTo(";");
    }
}