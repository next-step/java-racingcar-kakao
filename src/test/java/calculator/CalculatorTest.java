package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.InputMismatchException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Calculator 관련 테스트")
class CalculatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    void sum_메서드는_null이나_빈_문자열이_주어졌을_때_0을_반환(String input) {
        assertThat(Calculator.sum(input)).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3:6", "1:1"}, delimiter = ':')
    void sum_메서드는_입력_값의_합을_구함(String input, int sum) {
        assertThat(Calculator.sum(input)).isEqualTo(sum);
    }

    @ParameterizedTest
    @CsvSource(value = {"-1,2,3", "a,b,c"})
    void sum_메서드는_입력_값에_음수_및_숫자가_아닌_값이_전달된_경우_RuntimException이_발생() {
        assertThatThrownBy(() -> Calculator.sum("-1,2,3")).isInstanceOf(InputMismatchException.class);
    }
}
