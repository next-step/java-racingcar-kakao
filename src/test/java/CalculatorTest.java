import calculator.CalculateController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class CalculatorTest {

    CalculateController calculateController;

    @BeforeEach
    void setUp() {
        calculateController = new CalculateController();
    }

    @Test
    void emptyTest() {
        String emptyInput = "";
        int sum = calculateController.calculate(emptyInput);
        assertThat(sum).isEqualTo(0);
    }

    @Test
    void nullTest() {
        int sum = calculateController.calculate(null);
        assertThat(sum).isEqualTo(0);
    }

    @Test
    void commaTest() {
        String input = "1,2,2";
        int sum = calculateController.calculate(input);
        assertThat(sum).isEqualTo(5);
    }

    @Test
    void colonTest() {
        String input = "1;2;3";
        int sum = calculateController.calculate(input);
        assertThat(sum).isEqualTo(6);
    }

    @Test
    void customTest() {
        String input = "//;\n1;2;3";
        int sum = calculateController.calculate(input);
        assertThat(sum).isEqualTo(6);
    }

    @Test
    void minusExceptionTest() {
        String input = "-11;2";
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(()->{
                    calculateController.calculate(input);
                });
    }
    @Test
    void charExceptionTest() {
        String input = "asd;as";
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(()->{
                    calculateController.calculate(input);
                });
    }
}
