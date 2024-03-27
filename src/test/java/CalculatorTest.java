import calculator.Calculator;
import calculator.Delimiters;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private Calculator calculator;
    private Delimiters delimiters;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        delimiters = new Delimiters();
    }

    @Test
    void splitTest() {
        List<String> nums = delimiters.split("1,2:3");

        Assertions.assertEquals(nums.get(0), "1");
        Assertions.assertEquals(nums.get(1), "2");
        Assertions.assertEquals(nums.get(2), "3");
    }

    @Test
    void addCustomDelimiterTest() {
        delimiters.addCustomDelimiter(";");

        List<String> nums = delimiters.split("1;2:3");

        Assertions.assertEquals(3, nums.size());
        Assertions.assertEquals(nums.get(0), "1");
        Assertions.assertEquals(nums.get(1), "2");
    }

    @Test
    void parseDelimiterTest() {
        String customDelimiter1 = calculator.inputProcessor.parseCustomDelimiter("//;\n1,2:3")
            .orElse("fail");
        String customDelimiter2 = calculator.inputProcessor.parseCustomDelimiter("/;\n1,2:3")
            .orElse("fail");

        Assertions.assertEquals(";", customDelimiter1);
        Assertions.assertEquals("fail", customDelimiter2);
    }

    @Test
    void parseAndAddDelimiter() {
        String customDelimiter = calculator.inputProcessor.parseCustomDelimiter("//;\n1,2:3")
            .orElse("fail");
        delimiters.addCustomDelimiter(customDelimiter);

        List<String> nums = delimiters.split("1;2:3");

        Assertions.assertEquals(nums.get(0), "1");
        Assertions.assertEquals(nums.get(1), "2");
        Assertions.assertEquals(nums.get(2), "3");
    }

    @Test
    void validateInputGoodCaseTest() {
        calculator.inputProcessor.validateInput("1:1:1");
        calculator.inputProcessor.validateInput("//;\n1:2;3");
    }

    @Test
    void validateInputBadCaseTest() {
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> calculator.inputProcessor.validateInput("000:1:1"));
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> calculator.inputProcessor.validateInput("//;\n1:1:1-"));
    }

    @Test
    void addShouldReturnSumOfNumbersSeparatedByComma() {
        Calculator calculator = new Calculator();
        int result = calculator.add("1,2,3");
        Assertions.assertEquals(6, result);
    }

    @Test
    void addShouldReturnSumOfNumbersSeparatedByColon() {
        int result = calculator.add("1:2:3");
        Assertions.assertEquals(6, result);
    }

    @Test
    void addShouldReturnSumOfNumbersSeparatedByCustomDelimiter() {
        int result = calculator.add("//;\n1;2;3");
        Assertions.assertEquals(6, result);
    }

    @Test
    void addShouldThrowExceptionWhenInputIsInvalid() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.add("1:1:1-"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.add(""));

    }
}
