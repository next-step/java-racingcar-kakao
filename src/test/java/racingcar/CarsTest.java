package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    void 쉼표로_구분된_차의_개수를_확인한다() {
        Cars cars = new Cars("pobi,crong,honux");

        assertThat(cars.count()).isEqualTo(3);
    }

    @Test
    void 레이싱_게임_결과를_반환한다() {
        Cars cars = new Cars("pobi,crong,honux");

        assertThat(cars.toString()).isEqualTo(
                "pobi : -\n" +
                        "crong : -\n" +
                        "honux : -"
        );
    }

    @Test
    void 우승자를_반환한다() {
        Cars cars = new Cars("pobi,crong,honux");
        cars.move();

        assertThat(cars.decideWinner()).containsAnyOf("pobi", "crong", "honux");
    }
}
