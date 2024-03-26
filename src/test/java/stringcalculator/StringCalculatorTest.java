package stringcalculator;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

	@Test
	@DisplayName("문자열을 입력받아 연산 결과를 반환")
	public void calculateTest() {
		String input = "1,2,3";
		Assertions.assertThat(StringCalculator.calculate(input)).isEqualTo(6);

		input = "1:2:3";
		Assertions.assertThat(StringCalculator.calculate(input)).isEqualTo(6);

		input = "1:2,3";
		Assertions.assertThat(StringCalculator.calculate(input)).isEqualTo(6);

		input = "1,2:3,10";
		Assertions.assertThat(StringCalculator.calculate(input)).isEqualTo(16);

		input = "1,,3";
		Assertions.assertThat(StringCalculator.calculate(input)).isEqualTo(4);

		input = "1, ,3";
		Assertions.assertThat(StringCalculator.calculate(input)).isEqualTo(4);
	}
}
