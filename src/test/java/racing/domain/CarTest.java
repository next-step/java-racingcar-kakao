package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

import racing.support.StubCarEngine;

public class CarTest {

    @Test
    void move() {
        // given
        CarEngine carEngine = new StubCarEngine(true);
        Car car = new Car("vecto", carEngine);

        // when
        car.move();

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void moveFail() {
        // given
        CarEngine carEngine = new StubCarEngine(false);
        Car car = new Car("vecto", carEngine);

        // when
        car.move();

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void name() {
        // given
        CarEngine carEngine = new StubCarEngine(true);
        Car car = new Car("vecto", carEngine);

        // when & then
        assertThat(car.getName()).isEqualTo("vecto");
    }

    @Test
    void exceedNameLength() {
        // given
        CarEngine carEngine = new StubCarEngine(true);

        // when & then
        assertThatThrownBy(() -> new Car("vector", carEngine))
                .isInstanceOf(RuntimeException.class);
    }
}
