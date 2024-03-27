import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.RacingCar;
import racingcar.model.RacingCars;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RacingCarTest {

    private RacingCar racingCar;

    @BeforeEach
    void setUp() {
        racingCar = new RacingCar();
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void moveTest(int number) {
        assertTrue(racingCar.isMove(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void stopTest(int number) {
        assertFalse(racingCar.isMove(number));
    }

    @Test
    void determineWinnerTest() {
        List<String> racingCarNames = Arrays.asList("car1", "car2", "car3");
        RacingCars racingCars = new RacingCars(racingCarNames);

        racingCars.getRacingCars().get(0).getNumAndMove(9);
        racingCars.getRacingCars().get(1).getNumAndMove(2);
        racingCars.getRacingCars().get(2).getNumAndMove(8);

        List<RacingCar> winners = racingCars.findWinners();

        Assertions.assertEquals(2, winners.size());
        Assertions.assertEquals("car1", winners.get(0).getName());
        Assertions.assertEquals("car3", winners.get(1).getName());
    }
}
