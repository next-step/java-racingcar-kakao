package racing_car;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class DiceResultTest {

    @Test
    void 올바른_범위_내의_숫자를_입력받으면_정상적으로_생성된다() {
        DiceResult diceResult = new DiceResult(9);
    }

    @Test
    void 범위_밖의_숫자를_입력받으면_예외를_던진다() {
        assertThatThrownBy(() -> new DiceResult(10))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 움직일_수_있는_경우_isMove가_true를_반환한다() {
        DiceResult diceResult = new DiceResult(9);

        assertThat(diceResult.isMove()).isTrue();
    }

    @Test
    void 움직일_수_없는_경우_isMove가_false를_반환한다() {
        DiceResult diceResult = new DiceResult(0);

        assertThat(diceResult.isMove()).isFalse();
    }
}
