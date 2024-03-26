package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열의 합을 계산한다.")
    void defaultSeparatorTest() {
        String input = "1,2:3,4:5,6";

        int result = calculator.calculate(input);

        assertEquals(21, result);
    }

    @Test
    @DisplayName("사용자 지정 구분자를 사용할 수 있다.")
    void customSeparatorTest() {
        String input = "//;\n1;2;3;4;5;6";

        int result = calculator.calculate(input);

        assertEquals(21, result);
    }

    @Test
    @DisplayName("사용자 지정 구분자를 추가할 수 있다.")
    void defaultAndCustomSeparatorTest() {
        String input = "//;\n1;2:3;4,5;6";

        int result = calculator.calculate(input);

        assertEquals(21, result);
    }

    @Test
    @DisplayName("음수를 전달하는 경우 예외를 발생한다.")
    void invalidNumberInputTest() {
        String input = "//;\n-1;2:3;4,5;6";

        assertThrows(RuntimeException.class,
                () -> calculator.calculate(input));
    }

    @Test
    @DisplayName("숫자 이외의 문자를 전달하는 경우 예외를 발생한다.")
    void invalidInputTest() {
        String input = "//;\nab;cd;ef";

        assertThrows(RuntimeException.class,
                () -> calculator.calculate(input));
    }
}
