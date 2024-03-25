package car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarMessageTest {
    @Test
    @DisplayName("현재 자동차의 위치 정보 메세지를 생성한다")
    void createMessageTest() {
        Car car = new Car("helen");
        for (int i = 0; i < 3; i++) {
            car.run(4);
        }

        assertEquals("helen : ---", car.generateMessage());
    }
}
