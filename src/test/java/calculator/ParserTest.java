package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

@DisplayName("Parser 관련 테스트")
class ParserTest {
    @Test
    void of는_input_문자열을_이용하여_Parser_객체를_생성() {
        assertThatCode(() -> Parser.of("")).doesNotThrowAnyException();
    }

    @Test
    void parse_메서드는_입력_값을_이용하여_Numbers_객체를_생성() {
        assertThat(Parser.of("").parse()).isInstanceOf(Numbers.class);
    }
}