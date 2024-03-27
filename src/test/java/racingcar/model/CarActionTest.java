package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarActionTest {

    @DisplayName("4이상의 값에서 전진을 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"0, STAND", "1, STAND", "2, STAND", "3, STAND", "4, MOVE", "5, MOVE", "6, MOVE", "7, MOVE", "8, MOVE", "9, MOVE"})
    void move_SuccessHigherOrEqual4(final int number, final CarAction expected) {
        // when
        final CarAction actual = CarAction.generate(number);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("입력받은 숫자가 0 ~ 9 사이가 아니면 예외 처리한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -10, 10, 11, 100, 1000, -100})
    void move_FailWhenInvalidValue(final int value) {
        // when & then
        assertThatThrownBy(() -> CarAction.generate(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값은 0 이상 9 이하여야 합니다.");
    }
}
