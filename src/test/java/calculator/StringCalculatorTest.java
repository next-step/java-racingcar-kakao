package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("문자열 계산기 단위 테스트")
public class StringCalculatorTest {

	@Test
	@DisplayName("빈 문자열 또는 null을 입력할 경우 0을 반환한다.")
	void 빈문자열_혹은_null() {
		StringCalculator calculator = new StringCalculator();
		assertThat(calculator.calculate("")).isEqualTo(0);
		assertThat(calculator.calculate(null)).isEqualTo(0);
	}

	@Test
	@DisplayName("숫자 하나를 입력할 경우 해당 숫자를 반환한다.")
	void 숫자하나() {
		StringCalculator calculator = new StringCalculator();
		assertThat(calculator.calculate("1")).isEqualTo(1);
	}

	@Test
	@DisplayName("기본 구분자를 기준으로 분리해 합을 계산한다.")
	void 기본구분자_분리() {
		StringCalculator calculator = new StringCalculator();
		assertThat(calculator.calculate("1,2")).isEqualTo(3);
		assertThat(calculator.calculate("1,2,3")).isEqualTo(6);
		assertThat(calculator.calculate("1,2:3")).isEqualTo(6);
	}
}
