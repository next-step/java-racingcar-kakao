import org.junit.jupiter.api.DisplayName;
import racingcar.model.Car;
import racingcar.model.RacingGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.view.InputValidator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DisplayName("레이싱 테스트")
public class RacingTest {

    Car car;

    InputValidator inputValidator;

    RacingGame racingGame;

    @BeforeEach
    void setUp() {
        car = new Car("abc");
        inputValidator = new InputValidator();
    }
    @Test
    @DisplayName("전진 테스트")
    void forwardTest() {
        car.decideMovement(5);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("정지 테스트")
    void stayTest() {
        car.decideMovement(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }


    @Test
    @DisplayName("차 이름 생성 테스트")
    void createCarNameTest() {
        String input = "test";
        car = new Car(input);
        assertThat(car.getName()).isEqualTo(input);
    }

    @Test
    @DisplayName("차 여러대 생성 테스트")
    void createCarNameWithCommaTest() {
        String input = "fre,bas,123";
        String[] carList = inputValidator.createCarsFromUserInput(input);
        assertThat(carList.length).isEqualTo(3);
    }

    @Test
    @DisplayName("차 여러대 생성 익셉션 테스트")
    void createCarNameTestWithExceptionTest() {
        String input = "fre,bas132,123";
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(()->{
                    inputValidator.createCarsFromUserInput(input);
                });
    }

    @Test
    @DisplayName("우승자 테스트")
    void winnerTest() {
        racingGame = new RacingGame(inputValidator.createCarsFromUserInput("fre,bas,123"), 3);

        for (int i = 0; i < racingGame.getCars().size(); i++) {
            racingGame.getCars().get(i).decideMovement(i+2);
        }

        List<String> winners = racingGame.selectWinners();
        assertThat(winners.get(0)).isEqualTo("123");
    }
}
