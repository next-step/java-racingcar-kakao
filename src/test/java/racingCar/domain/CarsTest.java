package racingCar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.NumberGenerator;

@DisplayName("Cars 딘위 테스트")
class CarsTest {

    @Test
    @DisplayName("자동차들을 생성한다.")
    void 자동차_생성() {
        Cars cars = new Cars("pobi,crong,honux");
        List<String> carNames = cars.getCarNames();
        assertThat(carNames).containsExactly("pobi", "crong", "honux");
    }

    @Test
    @DisplayName("자동차들을 이동시킨다.")
    void 자동차_이동_시도() {
        Cars cars = new Cars("pohi,crong,honux");
        cars.move(new MockNumberGenerator());

        assertThat(cars.getCarPositions()).containsExactly(1, 1, 0);
    }

    @Test
    @DisplayName("우승자 목록을 반환한다.")
    void 우승자_목록_반환() {
        Cars cars = new Cars("pohi,crong,honux");
        cars.move(new MockNumberGenerator());

        assertThat(cars.getWinners()).containsExactly("pohi", "crong");
    }

    static class MockNumberGenerator extends NumberGenerator {
        int n = 0;

        @Override
        public int generateNumber() {
            if (n < 2) {
                n++;
                return 10;
            }
            return 1;
        }
    }
}