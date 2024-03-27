package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Car 관련 테스트")
public class CarTest {
    @ParameterizedTest
    @NullAndEmptySource
    void 자동차의_이름이_null_혹은_빈_문자열인_경우_RuntimeException이_발생(String input) {
        assertThatThrownBy(() -> Car.of(input)).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"jseo", "glen", "sage", "felix", "zero", "basil"})
    void 자동차의_이름은_5글자_이하(String input) {
        assertThatCode(() -> Car.of(input)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @CsvSource(value = {"benjamin", "silvia"})
    void 자동자의_이름이_5글자_이상인_경우_RuntimeException이_발생(String input) {
        assertThatThrownBy(() -> Car.of(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차는_4이상의_입력에서_전진_가능() {
        Car car = new Car("jseo") {
            @Override
            protected int pickEngineValue() {
                return 4;
            }
        };
        int init = car.offset();
        car.move();
        assertThat(init).isLessThan(car.offset());
    }

    @Test
    void 자동차는_3이하의_입력에서는_전진_불가() {
        Car car = new Car("jseo") {
            @Override
            protected int pickEngineValue() {
                return 3;
            }
        };
        int init = car.offset();
        car.move();
        assertThat(init).isEqualTo(car.offset());
    }

    @Test
    void 자동차의_상태는_이름과_offset만큼의_bar로_구성() {
        Car car = new Car("jseo") {
            @Override
            protected int pickEngineValue() {
                return 4;
            }
        };
        car.move();
        assertThat(car.status()).isEqualTo("jseo : -");
    }
}
