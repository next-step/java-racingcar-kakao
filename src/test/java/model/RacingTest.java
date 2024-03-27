package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RacingTest {
    @Test
    @DisplayName("시도 횟수는 1 이상이어야 한다")
    void validateTryNumberTest() {
        int tryNumber = 0;

        assertThrows(IllegalArgumentException.class,
                () -> new RacingGame(Arrays.asList(new Car("first")), tryNumber));
    }

    @Test
    @DisplayName("가장 포지션 값이 높은 차가 우승한다.")
    void winTest() {
        Car first = new Car("a");
        Car second = new Car("b");
        Car third = new Car("c");

        // first round
        first.run(4);
        second.run(3);
        third.run(3);

        // second round
        first.run(4);
        second.run(4);
        third.run(3);

        RacingGame result = new RacingGame(Arrays.asList(first, second, third));
        assertThat(result.getWinners()).containsExactly(first);
    }

    @Test
    @DisplayName("우승자가 여러 명일 경우 모두 출력한다.")
    void multipleWinnersTest() {
        Car first = new Car("a");
        Car second = new Car("b");
        Car third = new Car("c");

        // first round
        first.run(4);
        second.run(4);
        third.run(3);

        // second round
        first.run(4);
        second.run(4);
        third.run(3);

        RacingGame result = new RacingGame(Arrays.asList(first, second, third));
        assertThat(result.getWinners()).containsExactlyInAnyOrder(first, second);
    }
}
