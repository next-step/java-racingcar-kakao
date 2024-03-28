package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.generator.NumberGenerator;
import racing.generator.RandomNumberGenerator;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    RacingGame racingGame;

    @BeforeEach
    void setUp() {
        NumberGenerator trueNumberGenerator = new RandomNumberGenerator() {
            @Override
            public int generate() {
                return 9;
            }
        };
        NumberGenerator falseNumberGenerator = new RandomNumberGenerator() {
            @Override
            public int generate() {
                return 0;
            }
        };
        this.racingGame = new RacingGame(
                Arrays.asList(
                        new Car("car1", trueNumberGenerator),
                        new Car("car2", falseNumberGenerator)
                )
        );

    }

    @Test
    void multipleCarProceed() {
        racingGame.proceed();

        assertThat(racingGame.findByName("car1").getPosition()).isEqualTo(1);
        assertThat(racingGame.findByName("car2").getPosition()).isEqualTo(0);
    }

    @Test
    void existCarName() {
        assertThat(racingGame.findByName("car1")).isNotNull();
    }

    @Test
    void notExistCarName() {
        assertThat(racingGame.findByName("no_name")).isNull();
    }

    @Test
    void getWinner() {
        racingGame.proceed();

        List<Car> cars = racingGame.getCarList();
        int maxPosition = racingGame.getMaxPosition(cars);
        List<Car> winner = racingGame.getWinner(cars, maxPosition);

        assertThat(winner.size()).isEqualTo(1);
        assertThat(winner.get(0).getCarName()).isEqualTo("car1");
    }
}
