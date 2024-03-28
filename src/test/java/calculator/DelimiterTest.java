package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class DelimiterTest {
    Delimiter delimiter;

    @BeforeEach
    void setUp() {
        delimiter = new Delimiter();
    }

    @Test
    void getDelimiter() {
        assertThat(delimiter.getDelimiter()).isEqualTo("[,;]");
    }

    @Test
    void delimiterContains() {
        assertAll(
                () -> assertThat(delimiter.contains(",")).isTrue(),
                () -> assertThat(delimiter.contains(";")).isTrue(),
                () -> assertThat(delimiter.contains("?")).isFalse()
        );
    }

    @Test
    void findCustomOperator() {
        String expression = "//?\\n1,2;3?4";

        expression = delimiter.findCustomOperator(expression);

        assertThat(expression).isEqualTo("1,2;3?4");
        assertThat(delimiter.contains("?")).isTrue();
    }

    @Test
    void split() {
        String expression = "1,2;3";

        List<Integer> numberList = delimiter.split(expression);

        assertAll(
                () -> assertThat(numberList.size()).isEqualTo(3),
                () -> assertThat(numberList.get(0)).isEqualTo(1),
                () -> assertThat(numberList.get(1)).isEqualTo(2),
                () -> assertThat(numberList.get(2)).isEqualTo(3)
        );
    }

    @Test
    void customSplit() {
        delimiter = new Delimiter(new String[]{"?"});

        String expression = "1,2;3?4";

        List<Integer> numberList = delimiter.split(expression);

        assertThat(numberList.size()).isEqualTo(4);
        assertThat(numberList.get(0)).isEqualTo(1);
        assertThat(numberList.get(1)).isEqualTo(2);
        assertThat(numberList.get(2)).isEqualTo(3);
        assertThat(numberList.get(3)).isEqualTo(4);
    }
}
