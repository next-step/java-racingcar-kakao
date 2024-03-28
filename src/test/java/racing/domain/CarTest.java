package racing.domain;

import org.junit.jupiter.api.Test;

import racing.generator.FalseNumberGenerator;
import racing.generator.TrueNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void go() {
        Car car = new Car("car_name", new TrueNumberGenerator());

        car.proceed();

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void stop() {
        Car car = new Car("car_name", new FalseNumberGenerator());

        car.proceed();

        assertThat(car.getPosition()).isEqualTo(0);
    }
}
