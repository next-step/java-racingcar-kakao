package racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;

import org.junit.jupiter.api.Test;

public class RaceTest {

    @Test
    void move() {
        Car vectorCar = new Car("vector");
        Car sageCar = new Car("sage");
        NumberGenerator generator = new StubNumberGenerator(7);
        Race race = new Race(generator, List.of(vectorCar, sageCar));
        race.move();

        assertAll(
                () -> assertThat(vectorCar.getPosition()).isEqualTo(1),
                () -> assertThat(sageCar.getPosition()).isEqualTo(1)
        );
    }

    @Test
    void moveFail() {
        Car vectorCar = new Car("vector");
        Car sageCar = new Car("sage");
        NumberGenerator generator = new StubNumberGenerator(0);
        Race race = new Race(generator, List.of(vectorCar, sageCar));
        race.move();

        assertAll(
                () -> assertThat(vectorCar.getPosition()).isEqualTo(0),
                () -> assertThat(sageCar.getPosition()).isEqualTo(0)
        );
    }
}
