package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Calculator 관련 테스트")
class CalculatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    void sum_메서드는_null이나_빈_문자열이_주어졌을_때_0을_반환(String input) {
        assertThat(Calculator.sum(input)).isEqualTo(0);
    }
}