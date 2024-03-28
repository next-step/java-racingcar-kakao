package racing.domain;

import org.junit.jupiter.api.Test;

import racing.generator.NumberGenerator;
import racing.generator.RandomNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void go() {
        NumberGenerator trueNumberGenerator = new RandomNumberGenerator() {
            @Override
            public int generate() {
                return 9;
            }
        };
        Car car = new Car("car_name", trueNumberGenerator);

        assertThat(car.proceed()).isTrue();
    }

    @Test
    void stop() {
        NumberGenerator falseNumberGenerator = new RandomNumberGenerator() {
            @Override
            public int generate() {
                return 0;
            }
        };
        Car car = new Car("car_name", falseNumberGenerator);

        assertThat(car.proceed()).isFalse();
    }
}
