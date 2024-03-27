package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Cars 관련 테스트")
public class CarsTest {
    @Test
    void Cars는_참가_신청된_이름을_바탕으로_생성() {
        Cars cars = Cars.of(
                Stream.of("jseo", "glen", "sage")
                        .map(Car::of)
                        .collect(Collectors.toList())
        );
        assertThat(cars.list()).isEqualTo(
                Stream.of("jseo", "glen", "sage")
                        .map(Car::of)
                        .collect(Collectors.toList())
        );
    }

    @Test
    void 중복_참여된_자동차들은_RuntimeException을_발생() {
        assertThatThrownBy(() -> Cars.of(
                Stream.of("jseo", "jseo")
                        .map(Car::of)
                        .collect(Collectors.toList())
        )).isInstanceOf(IllegalStateException.class);
    }

    @Test
    void moveAll_메서드를_이용하여_자동차들의_전진을_일괄적으로_수행() {
        Cars cars = Cars.of(
                List.of(overriddenCar("jseo"), overriddenCar("glen"), overriddenCar("sage"))
        );
        cars.moveAll();
        cars.list().forEach(car -> assertThat(car.offset()).isEqualTo(1));
    }

    private Car overriddenCar(String name) {
        return new Car(name) {
            @Override
            protected int pickEngineValue() {
                return 4;
            }
        };
    }

    @Test
    void statusAll_메서드를_이용하여_자동차들의_상태를_일괄적으로_파악() {
        Cars cars = Cars.of(
                List.of(overriddenCar("jseo"), overriddenCar("glen"), overriddenCar("sage"))
        );
        cars.moveAll();
        assertThat(cars.statusAll()).isEqualTo("jseo : -\nglen : -\nsage : -\n");
    }

    @Test
    void 자동차들의_list의_불변성을_확인() {
        Cars cars = Cars.of(
                Stream.of("jseo", "glen", "sage")
                        .map(Car::of)
                        .collect(Collectors.toList())
        );
        assertThatThrownBy(() -> cars.list().add(Car.of("fail")))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
