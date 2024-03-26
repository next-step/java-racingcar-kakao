package string_add_calculator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ParserTest {
    @Test
    void 커스텀_구분자가_존재하는_경우_커스텀_구분자로_자른다() {
        String hasDelimiter = "//a\n1a2a3";

        assertThat(Parser.parseNumbers(hasDelimiter))
                .isEqualTo(List.of(
                        new Number(1),
                        new Number(2),
                        new Number(3)
                ));
    }

    @Test
    void 기본_구분자가_존재하는_경우_기본_구분자로_자른다() {
        String hasNormalDelimiter = "1,2";

        assertThat(Parser.parseNumbers(hasNormalDelimiter))
                .isEqualTo(List.of(
                        new Number(1),
                        new Number(2)
                ));
    }

    @Test
    void 기본_구분자가_섞여_존재하는_경우_올바르게_자른다() {
        String hasNormalDelimiter = "1,2;3";

        assertThat(Parser.parseNumbers(hasNormalDelimiter))
                .isEqualTo(List.of(
                        new Number(1),
                        new Number(2),
                        new Number(3)
                ));
    }

    @Test
    void 기본_구분자와_커스텀_구분자가_섞여_존재하는_경우_올바르게_자른다() {
        String hasNormalDelimiter = "//b\n1b2,3;4";

        assertThat(Parser.parseNumbers(hasNormalDelimiter))
                .isEqualTo(List.of(
                        new Number(1),
                        new Number(2),
                        new Number(3),
                        new Number(4)
                ));
    }

    @Test
    void 빈_문자열의_경우_0을_반환한다() {
        String hasNormalDelimiter = "";

        assertThat(Parser.parseNumbers(hasNormalDelimiter))
                .isEqualTo(List.of(new Number(0)));
    }

    @Test
    void 널_문자열의_경우_0을_반환한다() {
        String hasNormalDelimiter = null;

        assertThat(Parser.parseNumbers(hasNormalDelimiter))
                .isEqualTo(List.of(new Number(0)));
    }

    @Test
    void 구분할_숫자가_없는_경우_구분_없이_반환한다() {
        String hasNormalDelimiter = "9";

        assertThat(Parser.parseNumbers(hasNormalDelimiter))
                .isEqualTo(List.of(new Number(9)));
    }
}
