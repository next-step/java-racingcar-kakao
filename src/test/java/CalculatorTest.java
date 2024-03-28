import calculator.CalculateController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("계산기 테스트")
public class CalculatorTest {

    CalculateController calculateController;

    @BeforeEach
    void setUp() {
        calculateController = new CalculateController();
    }

    @Test
    @DisplayName("빈입력값 테스트")
    void emptyTest() {
        String emptyInput = "";
        int sum = calculateController.calculate(emptyInput);
        assertThat(sum).isEqualTo(0);
    }

    @Test
    @DisplayName("NULL 테스트")
    void nullTest() {
        int sum = calculateController.calculate(null);
        assertThat(sum).isEqualTo(0);
    }

    @Test
    @DisplayName("콤마 테스트")
    void commaTest() {
        String input = "1,2,2";
        int sum = calculateController.calculate(input);
        assertThat(sum).isEqualTo(5);
    }

    @Test
    @DisplayName("콜론 테스트")
    void colonTest() {
        String input = "1;2;3";
        int sum = calculateController.calculate(input);
        assertThat(sum).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 테스트")
    void customTest() {
        String input = "//;\n1;2;3";
        int sum = calculateController.calculate(input);
        assertThat(sum).isEqualTo(6);
    }

    @Test
    @DisplayName("마이너스 익셉션 테스트")
    void minusExceptionTest() {
        String input = "-11;2";
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(()->{
                    calculateController.calculate(input);
                });
    }
    @Test
    @DisplayName("문자형 입력 익셉션 테스트")
    void charExceptionTest() {
        String input = "asd;as";
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(()->{
                    calculateController.calculate(input);
                });
    }
}
