package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class CalculatorTest {

    @Test
    void calculate() {
        Calculator calculator = new Calculator();

        List<Integer> numberList = Arrays.asList(1,2,3);

        Assertions.assertThat(calculator.calculate(numberList)).isEqualTo(6);
    }
}
