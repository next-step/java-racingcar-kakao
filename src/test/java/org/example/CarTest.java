package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    void car_cant_go() {
        Car car = new Car("pobi");
        car.forward(1);
        assertThat(car.getPosition()).isZero();
    }

    @Test
    void car_go() {
        Car car = new Car("pobi");
        car.forward(5);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void car_invalid_name_length() {
        assertThatThrownBy(() ->
                new Car("pobiTeacher")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void car_name() {
        Car car = new Car("pobi");
        assertThat(car).isInstanceOf(Car.class);
    }

    @Test
    void random() {
        int randomNumber = RandomIntegerGenerator.generateEndInclusive(0, 9);
        assertThat(randomNumber).isBetween(0, 9);
    }
}
