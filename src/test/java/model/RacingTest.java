package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class RacingTest {
    @Test
    @DisplayName("가장 포지션 값이 높은 차가 우승한다.")
    void winTest() {
        Car first = new Car("first");
        Car second = new Car("second");
        Car third = new Car("third");

        // first round
        first.run(4);
        second.run(3);
        third.run(3);

        // second round
        first.run(4);
        second.run(4);
        third.run(3);

        RacingGame result = new RacingGame(Arrays.asList(first, second, third));
        assertTrue(result.getWinners().contains(first));
    }

    @Test
    @DisplayName("우승자가 여러 명일 경우 모두 출력한다.")
    void multipleWinnersTest() {
        Car first = new Car("first");
        Car second = new Car("second");
        Car third = new Car("third");

        // first round
        first.run(4);
        second.run(4);
        third.run(3);

        // second round
        first.run(4);
        second.run(4);
        third.run(3);

        RacingGame result = new RacingGame(Arrays.asList(first, second, third));
        assertTrue(result.getWinners().contains(first));
        assertTrue(result.getWinners().contains(second));
    }
}
