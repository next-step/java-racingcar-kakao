package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarGameTest {

    @Test
    void carGame() {
        Cars cars = new Cars("pobi1,pobi2,pobi3,pobi4");

        assertThat(cars.getCarSize()).isEqualTo(4);
    }
}
