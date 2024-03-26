package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import racing.support.StubCarEngine;

public class CarTest {

    @Test
    void move() {
        // given
        CarEngine carEngine = new StubCarEngine(true);
        Car car = new Car("vector", carEngine);

        // when
        car.move();

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void moveFail() {
        // given
        CarEngine carEngine = new StubCarEngine(false);
        Car car = new Car("vector", carEngine);

        // when
        car.move();

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void name() {
        // given
        CarEngine carEngine = new StubCarEngine(true);
        Car car = new Car("vector", carEngine);

        // when & then
        assertThat(car.getName()).isEqualTo("vector");
    }
}
