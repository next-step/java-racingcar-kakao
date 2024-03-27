package racingCar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("RacingGame 단위 테스트")
public class RacingGameTest {

    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame("pobi,crong,honux", 2);
    }

    @Test
    @DisplayName("게임이 종료되면 true 값을 반환한다.")
    void 게임종료_참_반환() {
        racingGame.race();
        racingGame.race();

        assertThat(racingGame.isGameEnd()).isTrue();
    }
}
