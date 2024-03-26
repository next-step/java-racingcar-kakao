package org.example.racinggame;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarGameTest {

    @Test
    void carGame() {
        Cars cars = new Cars("pobi1,pobi2,pobi3,pobi4");

        assertThat(cars.getCarSize()).isEqualTo(4);
    }

    @Test
    void carGameTest() {
        Cars cars = new Cars("pobi1,pobi2,pobi3,pobi4");

        Car car = cars.getCar("pobi1");
        car.forward(5);

        List<String> winners = cars.getWinners();

        assertThat(car.getPosition()).isEqualTo(1);
        assertThat(winners).containsExactly("pobi1");
        assertThat(winners).hasSize(1);
    }

    @Test
    void carGameTest_multipleWinner() {
        Cars cars = new Cars("pobi1,pobi2,pobi3,pobi4");

        Car car = cars.getCar("pobi1");
        car.forward(5);

        Car car2 = cars.getCar("pobi2");
        car2.forward(5);

        List<String> winners = cars.getWinners();
        assertThat(car.getPosition()).isEqualTo(1);
        assertThat(car2.getPosition()).isEqualTo(1);
        assertThat(winners).containsExactly("pobi1", "pobi2");
        assertThat(winners).hasSize(2);
    }
}
