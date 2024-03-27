package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RacingTest {
    @Test
    @DisplayName("가장 포지션 값이 높은 차가 우승한다.")
    void winTest() {
        Car first = generateTestCar("1등", 3);
        Car second = generateTestCar("2등", 2);
        Car third = generateTestCar("3등", 1);

        RacingGame result = new RacingGame(Arrays.asList(first, second, third));
        assertTrue(result.getWinners().contains(first));
    }

    @Test
    @DisplayName("우승자가 여러 명일 경우 모두 출력한다.")
    void multipleWinnersTest() {
        Car first = generateTestCar("1등", 3);
        Car sameFirst = generateTestCar("같은1등", 3);
        Car third = generateTestCar("3등", 1);

        RacingGame result = new RacingGame(Arrays.asList(first, sameFirst, third));
        assertTrue(result.getWinners().contains(first));
        assertTrue(result.getWinners().contains(sameFirst));
    }

    private Car generateTestCar(String name, int position) {
        Car car = new Car(name);
        for (int i = 0; i < position; i++) {
            car.run(Car.CAR_MOVE_THRESHOLD);
        }
        return car;
    }
}
