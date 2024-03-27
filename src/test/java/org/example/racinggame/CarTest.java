package org.example.racinggame;

import org.example.racinggame.model.Car;
import org.example.racinggame.utils.RandomIntegerGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

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

    @ParameterizedTest
    @NullAndEmptySource
    void car_name_test(String name) {
        assertThatThrownBy(() ->
                new Car(name)).isInstanceOf(IllegalArgumentException.class);
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
