package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameControllerTest {

    @Test
    void 레이싱_게임_결과를_반환한다() {
        GameController gameController = new GameController("pobi,crong,honux");

        assertThat(gameController.makeGameBoard()).isEqualTo(
                "pobi : -\n" +
                        "crong : -\n" +
                        "honux : -"
        );
    }

    @Test
    void 우승자를_반환한다() {
        GameController gameController = new GameController("pobi,crong,honux");
        List<Car> cars = gameController.getCars();

        cars.get(0).move();

        assertThat(gameController.decideWinner()).isEqualTo(List.of("pobi"));
    }
}
