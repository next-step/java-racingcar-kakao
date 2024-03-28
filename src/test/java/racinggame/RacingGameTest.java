package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("RacingGame 관련 테스트")
class RacingGameTest {
    @ParameterizedTest
    @MethodSource("getRacingGame")
    void 각_라운드_상태를_담은_rounds의_불변성을_확인(List<Car> cars, int trial) {
        RacingGame racingGame = RacingGame.of(Cars.of(cars), trial);
        assertThatThrownBy(() -> racingGame.rounds().add("non-addable"))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @ParameterizedTest
    @MethodSource("getRacingGame")
    void 최종_우승자들을_담은_winners의_불변성을_확인(List<Car> cars, int trial) {
        RacingGame racingGame = RacingGame.of(Cars.of(cars), trial);
        assertThatThrownBy(() -> racingGame.winners().add("non-addable"))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @ParameterizedTest
    @MethodSource("getRacingGame")
    void 최종_우승자의_유효성을_확인(List<Car> cars, int trial, List<String> winners) {
        RacingGame racingGame = RacingGame.of(Cars.of(cars), trial);
        racingGame.run();
        assertThat(racingGame.winners()).isEqualTo(winners);
    }

    private static Stream<Arguments> getRacingGame() {
        return Stream.of(
                Arguments.of(uniqueForwardable(), 1, List.of("jseo")),
                Arguments.of(duplicatedForwardable(), 1, List.of("jseo", "glen"))
        );
    }

    private static List<Car> uniqueForwardable() {
        return List.of(
                forwardableCar("jseo"),
                nonForwardableCar("glen"),
                nonForwardableCar("sage")
        );
    }

    private static List<Car> duplicatedForwardable() {
        return List.of(
                forwardableCar("jseo"),
                forwardableCar("glen"),
                nonForwardableCar("sage")
        );
    }

    private static Car nonForwardableCar(String name) {
        return new Car(name) {
            @Override
            protected int pickEngineValue() {
                return 3;
            }
        };
    }

    private static Car forwardableCar(String name) {
        return new Car(name) {
            @Override
            protected int pickEngineValue() {
                return 4;
            }
        };
    }
}