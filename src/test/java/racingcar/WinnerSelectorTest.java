package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.controller.RacingController;
import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.model.WinnerSelector;

public class WinnerSelectorTest {
	WinnerSelector winnerSelector;
	RacingGame racingGame;
	RacingController racingController;

	@BeforeEach
	void setUp(){
		racingController = new RacingController();
		winnerSelector = new WinnerSelector();
	}

	@Test
	@DisplayName("우승자 테스트")
	void winnerTest() {
		racingGame = new RacingGame(racingController.createCarNamesFromUserInput("fre,bas,123"), 3);
		for (Car car : racingGame.getCars()) {
			car.moveForwardIfCan(4);
		}

		List<String> winners = winnerSelector.selectWinners(racingGame.getCars());

		assertThat(winners.get(0)).isEqualTo("fre");
		assertThat(winners.get(1)).isEqualTo("bas");
		assertThat(winners.get(2)).isEqualTo("123");
	}
}
