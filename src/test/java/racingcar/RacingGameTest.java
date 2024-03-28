package racingcar;

import org.junit.jupiter.api.DisplayName;

import racingcar.controller.RacingController;
import racingcar.model.Car;
import racingcar.model.RacingGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.*;

@DisplayName("레이싱 테스트")
public class RacingGameTest {

	RacingController racingController;
	RacingGame racingGame;

	String carNames;

	@BeforeEach
	void setUp() {
		racingController = new RacingController() {
			@Override
			public void gameSetting() {
				String[] names = createCarNamesFromUserInput(carNames);
				racingGame = new RacingGame(names, 3);
			}
		};
	}

	@Test
	@DisplayName("차 여러대 생성 테스트")
	void createCarNameWithCommaTest() {
		carNames = "fre,bas,123";
		racingController.gameSetting();
		assertThat(racingGame.getCarsLength()).isEqualTo(3);
	}

	@Test
	@DisplayName("차 여러대 생성 익셉션 테스트")
	void createCarNameTestWithExceptionTest() {
		carNames = "fre,bas132,123";
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() ->
				racingController.gameSetting()
			);
	}

	@Test
	@DisplayName("4 이상 이동 테스트")
	void moveCarsWithNumberOver4() {
		String[] names = {"fre", "test", "est"};

		racingGame = new RacingGame(names, 3) {
			@Override
			public int createRandomNumber() {
				return 4;
			}
		};

		racingGame.move();

		for (Car car : racingGame.getCars()) {
			assertThat(car.getPosition()).isEqualTo(1);
		}
	}

	@Test
	@DisplayName("3 이하 정지 테스트")
	void moveCarsWithNumberUnder4() {
		String[] names = {"fre", "test", "est"};

		racingGame = new RacingGame(names, 3) {
			@Override
			public int createRandomNumber() {
				return 3;
			}
		};

		racingGame.move();

		for (Car car : racingGame.getCars()) {
			assertThat(car.getPosition()).isEqualTo(0);
		}
	}
}
