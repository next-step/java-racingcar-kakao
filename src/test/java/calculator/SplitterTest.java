package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class SplitterTest {
    Delimiter delimiter;
    Splitter splitter;

    @BeforeEach
    void setUp() {
        this.delimiter = new Delimiter();
        this.splitter = new Splitter();
    }

    @Test
    void split() {
        String expression = "1,2;3";

        List<Integer> numberList = splitter.split(expression, delimiter);

        Assertions.assertThat(numberList.size()).isEqualTo(3);
        Assertions.assertThat(numberList.get(0)).isEqualTo(1);
        Assertions.assertThat(numberList.get(1)).isEqualTo(2);
        Assertions.assertThat(numberList.get(2)).isEqualTo(3);
    }

    @Test
    void customSplit() {
        delimiter.add("?");

        String expression = "1,2;3?4";

        List<Integer> numberList = splitter.split(expression, delimiter);

        Assertions.assertThat(numberList.size()).isEqualTo(4);
        Assertions.assertThat(numberList.get(0)).isEqualTo(1);
        Assertions.assertThat(numberList.get(1)).isEqualTo(2);
        Assertions.assertThat(numberList.get(2)).isEqualTo(3);
        Assertions.assertThat(numberList.get(3)).isEqualTo(4);
    }
}
