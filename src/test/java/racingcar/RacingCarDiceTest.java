package racingcar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarDiceTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 주사위_눈이_4이상이면_IsMove_참을_반환한다(int diceNum) {
        assertThat(RacingCarDice.isMove(diceNum)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 주사위_눈이_4미만이면_IsMove_거짓을_반환한다(int diceNum) {
        assertThat(RacingCarDice.isMove(diceNum)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 10})
    void 주사위_눈이_범위를_벗어나면_IllegalArgumentException을_던진다(int diceNum) {
        assertThatThrownBy(() -> RacingCarDice.isMove(diceNum))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
