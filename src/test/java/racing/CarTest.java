package racing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void move() {
        Car car = new Car("vector");
        car.move(7);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void moveFail() {
        Car car = new Car("vector");
        car.move(1);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void name() {
         Car car = new Car("vector");
         assertThat(car.getName()).isEqualTo("vector");
    }
}
