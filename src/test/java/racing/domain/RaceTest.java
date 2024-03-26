package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;

import org.junit.jupiter.api.Test;

import racing.support.StubCarEngine;

public class RaceTest {

    @Test
    void move() {
        // given
        CarEngine carEngine = new StubCarEngine(true);
        Car vectorCar = new Car("vector", carEngine);
        Car sageCar = new Car("sage", carEngine);
        Race race = new Race(List.of(vectorCar, sageCar));

        // when
        race.move();

        // then
        assertAll(
                () -> assertThat(vectorCar.getPosition()).isEqualTo(1),
                () -> assertThat(sageCar.getPosition()).isEqualTo(1)
        );
    }

    @Test
    void moveFail() {
        // given
        CarEngine carEngine = new StubCarEngine(false);
        Car vectorCar = new Car("vector", carEngine);
        Car sageCar = new Car("sage", carEngine);
        Race race = new Race(List.of(vectorCar, sageCar));

        // when
        race.move();

        // then
        assertAll(
                () -> assertThat(vectorCar.getPosition()).isEqualTo(0),
                () -> assertThat(sageCar.getPosition()).isEqualTo(0)
        );
    }

    @Test
    void winners() {
        // given
        CarEngine carEngine = new StubCarEngine(true);
        Car vectorCar = new Car("vector", carEngine);
        Car sageCar = new Car("sage", carEngine);
        Car amberCar = new Car("amber", carEngine);
        Race race = new Race(List.of(vectorCar, sageCar, amberCar));

        // when
        sageCar.move();
        List<String> winners = race.winners();

        // then
        assertThat(winners).containsExactlyInAnyOrder("sage");
    }

    @Test
    void winners2() {
        // given
        CarEngine carEngine = new StubCarEngine(true);
        Car vectorCar = new Car("vector", carEngine);
        Car sageCar = new Car("sage", carEngine);
        Car amberCar = new Car("amber", carEngine);
        Race race = new Race(List.of(vectorCar, sageCar, amberCar));

        // when
        sageCar.move();
        amberCar.move();
        List<String> winners = race.winners();

        // then
        assertThat(winners).containsExactlyInAnyOrder("sage", "amber");
    }

    @Test
    void winners3() {
        // given
        CarEngine carEngine = new StubCarEngine(true);
        Car vectorCar = new Car("vector", carEngine);
        Car sageCar = new Car("sage", carEngine);
        Car amberCar = new Car("amber", carEngine);
        Race race = new Race(List.of(vectorCar, sageCar, amberCar));

        // when
        race.move();
        List<String> winners = race.winners();

        // then
        assertThat(winners).containsExactlyInAnyOrder("sage", "amber", "vector");
    }
}
