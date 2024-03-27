package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Numbers 관련 테스트")
class NumbersTest {
    @Test
    void list_메서드는_Numbers가_보유하고_있는_리스트를_반환() {
        assertThat(Numbers.of(List.of(1, 2, 3)).list()).isEqualTo(List.of(1, 2, 3));
    }
}