package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import racing.infra.RandomCarEngine;

public class RaceTest {

    private static CarEngine brokenEngine;
    private static CarEngine normalEngine;

    @BeforeAll
    static void beforeAll() {
        brokenEngine = new RandomCarEngine() {
            @Override
            protected int generateRandomCondition() {
                return 0;
            }
        };

        normalEngine = new RandomCarEngine() {
            @Override
            protected int generateRandomCondition() {
                return 9;
            }
        };
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    void 유일한_승자(int round) {
        Race race = new Race(List.of(
            new Car("sage", normalEngine),
            new Car("vec", brokenEngine),
            new Car("amber", brokenEngine)
        ));

        for (int i = 0; i < round; ++i) {
            race.nextRound();
        }

        assertThat(race.getWinnersName()).containsExactly("sage");
    }

    @Test
    void 공동승리_0라운드() {
        Race race = new Race(List.of(
            new Car("sage", normalEngine),
            new Car("vec", brokenEngine),
            new Car("amber", brokenEngine)
        ));

        assertThat(race.getWinnersName())
            .containsExactlyInAnyOrder("sage", "vec", "amber");
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    void 공동승리_1라운드_이상(int round) {
        Race race = new Race(List.of(
            new Car("sage", normalEngine),
            new Car("vec", normalEngine),
            new Car("amber", brokenEngine)
        ));

        for (int i = 0; i < round; ++i) {
            race.nextRound();
        }

        assertThat(race.getWinnersName())
            .containsExactlyInAnyOrder("sage", "vec");
    }
}
