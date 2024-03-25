import domain.Car;
import domain.RacingGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.InputValidator;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    Car car;

    InputValidator inputValidator;

    RacingGame racingGame;

    @BeforeEach
    void setUp() {
        car = new Car();
        inputValidator = new InputValidator();
    }
    @Test
    void forwardTest() {
        car.checkForwardMotion(5);
        assertThat(car.position).isEqualTo(1);
    }

    @Test
    void stayTest() {
        car.checkForwardMotion(3);
        assertThat(car.position).isEqualTo(0);
    }


    @Test
    void createCarNameTest() {
        String input = "test";
        car = new Car(input);
        assertThat(car.name).isEqualTo(input);
    }

    @Test
    void createCarNameWithCommaTest() {
        String input = "fre,bas,123";
        String[] carList = inputValidator.createCarsFromUserInput(input);
        assertThat(carList.length).isEqualTo(3);
    }

    @Test
    void createCarNameTestWithExceptionTest() {
        String input = "fre,bas132,123";
        String[] carList = inputValidator.createCarsFromUserInput(input);
        assertThat(carList).isEqualTo(null);
    }

    @Test
    void gameSettingTest() {
        racingGame = new RacingGame(inputValidator.createCarsFromUserInput("fre,bas,123"));
        assertThat(racingGame.cars.length).isEqualTo(3);
    }

    @Test
    void winnerTest() {
        racingGame = new RacingGame(inputValidator.createCarsFromUserInput("fre,bas,123"));
        for (int i = 0; i < racingGame.cars.length; i++) {
            racingGame.cars[i].position = i;
        }
        List<String> winners = racingGame.selectWinners();
        assertThat(winners.get(0)).isEqualTo("123");
    }
}
