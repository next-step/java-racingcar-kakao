package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import racing.domain.Car;

public class CarTest {

    @Test
    void move() {
        // given
        Car car = new Car("vector");

        // when
        car.move(7);

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void moveFail() {
        // given
        Car car = new Car("vector");

        // when
        car.move(1);

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void name() {
        // given
         Car car = new Car("vector");

         // when & then
         assertThat(car.getName()).isEqualTo("vector");
    }
}
