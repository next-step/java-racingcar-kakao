package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    void 이름_길이가_다섯_글자_이하면_정상적으로_생성한다() {
        Car car = new Car("Mark");

        assertThat(car.getName()).isEqualTo("Mark");
    }

    @Test
    void 이름_길이가_다섯_글자_초과면_예외를_던진다() {
        assertThatThrownBy(() -> new Car("Programmer"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차가_전진한다() {
        Car car = new Car("Move");
        int previousPosition = car.getPosition();

        car.move(5);
        assertThat(car.getPosition()).isEqualTo(previousPosition + 1);
    }

    @Test
    void 숫자가_작으면_자동차가_전진하지_않는다() {
        Car car = new Car("NoMov");
        int previousPosition = car.getPosition();

        car.move(0);
        assertThat(car.getPosition()).isEqualTo(previousPosition);
    }


    @Test
    void 생성_직후_문자열화하면_디폴트_값을_출력한다() {
        Car car = new Car("Mark");

        assertThat(car.toString()).isEqualTo("Mark : -");
    }

    @Test
    void 문자열화하면_자신의_이름과_함께_위치를_반환한다() {
        Car car = new Car("Mark");
        car.move(7);

        assertThat(car.toString()).isEqualTo("Mark : --");
    }
}
