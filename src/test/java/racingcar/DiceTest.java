package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DiceTest {

    @Test
    void 주사위를_던지면_0에서_9_사이의_숫자를_반환한다() {
        Dice dice = new Dice();
        int diceNum = dice.throwOnce();

        assertThat(diceNum)
                .isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(9);
    }
}
