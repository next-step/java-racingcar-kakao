package racing;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    void commaSeperatedCarNames() {
        RacingGame racingGame = new RacingGame("pobi,crong,honux", new RealRandomStrategy());
        List<Car> cars = racingGame.getCars();
        assertThat(cars.size()).isEqualTo(3);
        assertThat(cars.get(0).getName()).isEqualTo("pobi");
        assertThat(cars.get(1).getName()).isEqualTo("crong");
        assertThat(cars.get(2).getName()).isEqualTo("honux");
    }

    @Test
    void winner() {
        RandomStrategy rs = new FakeRandomStrategy(List.of(3, 4, 4));
        RacingGame racingGame = new RacingGame(
                List.of(new Car("pobi"),
                        new Car("crong"),
                        new Car("honux")),
                rs
        );
        racingGame.moveCars();
        List<Car> winners = racingGame.getWinners();

        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners.get(0).getName()).isEqualTo("crong");
        assertThat(winners.get(1).getName()).isEqualTo("honux");
    }

    @Test
    void moveCars() {
        RandomStrategy rs = new FakeRandomStrategy(List.of(4, 4, 3));
        RacingGame racingGame = new RacingGame(
                List.of(new Car("pobi"),
                        new Car("crong"),
                        new Car("honux")),
                rs
        );
        racingGame.moveCars();
        List<Car> cars = racingGame.getCars();
        assertThat(cars.get(0).getPosition()).isEqualTo(1);
        assertThat(cars.get(1).getPosition()).isEqualTo(1);
        assertThat(cars.get(2).getPosition()).isEqualTo(0);
    }
}