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

    @Test
    void construct_fail2() {
        assertThatThrownBy(() -> new Number("q"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 빈_문자열의_경우_0으로_치환한다() {
        assertThat(new Number("")).isEqualTo(new Number(0));
    }

    @Test
    void 널의_경우_0으로_치환한다() {
        assertThat(new Number(null)).isEqualTo(new Number(0));
    }
}
