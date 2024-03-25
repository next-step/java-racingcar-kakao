package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}
