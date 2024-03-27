package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CalculatorTest {

    private static final Calculator CALCULATOR = new Calculator();

    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.")
    @ParameterizedTest(name = "{0}을 입력했을 때")
    @NullAndEmptySource
    void emptyTest(final String text) {
        // when
        final int actual = CALCULATOR.calculate(text);

        // then
        assertThat(actual).isZero();
    }

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    @ParameterizedTest(name = "{0}을 입력했을 때")
    @CsvSource(value = {"0, 0", "1, 1", "2, 2", "10, 10", "987, 987"})
    void inputSingleTextTest(final String text, final int expected) {
        // when
        final int actual = CALCULATOR.calculate(text);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    @ParameterizedTest(name = "{0}을 입력했을 때 {1}이 반환된다.")
    @CsvSource(delimiter = ':', value = {"0,0 : 0", "1,1 : 2", "2,5 : 7", "10,43 : 53"})
    void commaTest(final String text, final int expected) {
        // when
        final int actual = CALCULATOR.calculate(text);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("구분자를 컴마(,) 이외에 세미콜론(;)을 사용할 수 있다.")
    @ParameterizedTest(name = "{0}을 입력했을 때, {1}이 반환된다.")
    @CsvSource(delimiter = ':', value = {"0,0 : 0", "1,1;1 : 3", "2;5 : 7", "10;43,11 : 64"})
    void commaAndSemicolonTest(final String text, final int expected) {
        // when
        final int actual = CALCULATOR.calculate(text);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("“//”와 “\\n” 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\\n1;2;3” => 6)")
    @ParameterizedTest(name = "{0}을 입력했을 때, {1}이 반환된다.")
    @CsvSource(delimiter = ':', value = {"//@\\n1@2@3 : 6", "//!\\n1!2!3 : 6", "//#\\n1#2#3#4 : 10"})
    void customDelimiterTest(final String text, final int expected) {
        // when
        final int actual = CALCULATOR.calculate(text);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : “-1,2,3”)")
    @ParameterizedTest(name = "{0}을 입력했을 때, {1}이 반환된다.")
    @ValueSource(strings = {"-1", "-1,2,3", "-1,-2,-3", "1,-2,3"})
    void negativeInputTest(final String text) {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            CALCULATOR.calculate(text);
        });
    }
}
