package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    @Test
    @DisplayName("쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열의 합을 계산한다.")
    void defaultSeparatorTest() {
        Calculator calculator = new Calculator();
        String input = "1,2:3,4:5,6";

        int result = calculator.calculate(input);

        assertEquals(21, result);
    }
}
