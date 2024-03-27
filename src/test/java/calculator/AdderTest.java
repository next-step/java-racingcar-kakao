package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("Adder 관련 테스트")
public class AdderTest {
    @Test
    void sum_메서드는_주어진_정수_리스트의_합을_반환할_수_있습니다() {
        List<Integer> numbers = List.of(1, 2, 3);
        Assertions.assertThat(Adder.sum(numbers)).isEqualTo(6);
    }
}
