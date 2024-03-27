package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.CustomNumberGenerator;
import racingcar.model.RacingGame;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {

    @DisplayName("게임을 완료한 후 우승자를 반환한다.")
    @Test
    void winnersTest() {
        // given
        final RacingGame racingGame = new RacingGame("lucas,dino,helen,eve", new CustomNumberGenerator(List.of(2, 9, 2, 1, 2, 9, 2, 1)), 2);

        // when
        racingGame.play();
        racingGame.play();

        // then
        assertAll(
                () -> assertThat(racingGame.isEnd()).isTrue(),
                () -> assertThat(racingGame.getWinnerNames()).hasSize(1),
                () -> assertThat(racingGame.getWinnerNames()).contains("dino")
        );
    }
}
