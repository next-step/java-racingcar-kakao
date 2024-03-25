package car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {
    @Test
    @DisplayName("랜덤 값이 4 이상일 경우 전진한다")
    void forwardTest() {
        Car car = new Car();
        car.run(4);
        assertTrue(car.getPosition() > 0);
    }

    @Test
    @DisplayName("랜덤 값이 3 이하일 경우 멈춘다")
    void stopTest() {
        Car car = new Car();
        car.run(3);
        assertEquals(0, car.getPosition());
    }
}
