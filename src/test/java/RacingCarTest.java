import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.RacingCar;
import racingcar.model.RacingCars;

public class RacingCarTest {

    private RacingCar racingCar;

    @BeforeEach
    void setUp() {
        racingCar = new RacingCar();
    }

    @Test
    void moveTest() {
        for (int i = 4; i < 10; i++) {
            boolean moveOrNot = racingCar.isMove(i);
            Assertions.assertTrue(moveOrNot);
        }
    }

    @Test
    void stopTest() {
        for (int i = 0; i < 4; i++) {
            boolean moveOrNot = racingCar.isMove(i);
            Assertions.assertFalse(moveOrNot);
        }
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
