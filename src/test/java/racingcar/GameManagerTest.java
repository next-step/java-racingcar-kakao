package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameManagerTest {

    @Test
    void 우승자를_반환한다() {
        Car winner = new Car("Mark", 3);
        GameManager gameManager = new GameManager(List.of(
                winner,
                new Car("Daisy", 1),
                new Car("Rosie", 1)
        ));

        List<Car> winners = gameManager.decideWinner();
        assertThat(winners).containsExactly(winner);
    }
}
