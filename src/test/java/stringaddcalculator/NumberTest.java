package stringaddcalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest {

    @Test
    void add() {
        Number n1 = new Number(1);
        Number n2 = new Number(2);
        assertThat(n1.add(n2)).isEqualTo(new Number(3));
    }

    @Test
    void construct_fail() {
        assertThatThrownBy(() -> new Number(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
