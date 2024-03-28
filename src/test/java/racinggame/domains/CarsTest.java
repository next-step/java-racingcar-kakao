package racinggame.domains;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@DisplayName("게임에 참가하는 자동차들 관련 테스트")
public class CarsTest {
    @Test
    @DisplayName("입력받은 차 이름을 바탕으로 객체를 초기화")
    void initialize() {
        Cars cars = Cars.of(List.of("pobi", "jseo", "owen"));

        assertThat(cars.values())
                .isEqualTo(List.of(
                        Car.of("pobi"),
                        Car.of("jseo"),
                        Car.of("owen")));
    }

    @Test
    @DisplayName("중복된 이름의 차를 가진 경우엔 예외를 발생")
    void filterDuplicated() {
        assertThatThrownBy(() -> Cars.of(List.of("jseo", "jseo"))).isInstanceOf(InputMismatchException.class);
    }
}
