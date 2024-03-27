import calculator.CalculatorController;
import calculator.Delimiter;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private Delimiter delimiter;

    @BeforeEach
    void setUp() {
        delimiter = new Delimiter();
    }

    @Test
    void splitTest() {
        List<String> nums = delimiter.split("1,2:3");

        Assertions.assertEquals(nums.get(0), "1");
        Assertions.assertEquals(nums.get(1), "2");
        Assertions.assertEquals(nums.get(2), "3");
    }

    @Test
    void addCustomDelimiterTest() {
        delimiter.addCustomDelimiter(";");

        List<String> nums = delimiter.split("1;2:3");

        Assertions.assertEquals(3, nums.size());
        Assertions.assertEquals(nums.get(0), "1");
        Assertions.assertEquals(nums.get(1), "2");
    }

    @Test
    void parseDelimiterTest() {
        CalculatorController calculatorController = new CalculatorController();

        String customDelimiter1 = calculatorController.parseCustomDelimiter("//;\\n1,2:3")
            .orElse("fail");
        String customDelimiter2 = calculatorController.parseCustomDelimiter("/;\\n1,2:3")
            .orElse("fail");

        Assertions.assertEquals(";", customDelimiter1);
        Assertions.assertEquals("fail", customDelimiter2);
    }

    @Test
    void parseAndAddDelimiter() {
        CalculatorController calculatorController = new CalculatorController();

        String customDelimiter = calculatorController.parseCustomDelimiter("//;\\n1,2:3")
            .orElse("fail");
        delimiter.addCustomDelimiter(customDelimiter);

        List<String> nums = delimiter.split("1;2:3");

        Assertions.assertEquals(nums.get(0), "1");
        Assertions.assertEquals(nums.get(1), "2");
        Assertions.assertEquals(nums.get(2), "3");
    }

    @Test
    void validateInputGoodCaseTest() {
        CalculatorController calculatorController = new CalculatorController();

        calculatorController.validateInput("1:1:1");
        calculatorController.validateInput("//;\n1:2;3");
    }

    @Test
    void validateInputBadCaseTest() {
        CalculatorController calculatorController = new CalculatorController();

        Assertions.assertThrows(IllegalArgumentException.class,
            () -> calculatorController.validateInput("000:1:1"));
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> calculatorController.validateInput("//;\n1:1:1-"));
    }
}
