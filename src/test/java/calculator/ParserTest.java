package calculator;

import calculator.domains.Parser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("파서 관련 테스트")
public class ParserTest {
    @Test
    @DisplayName("쉼표를 구분자로 하는 정수 문자열을 정수 리스트로 파싱")
    void parseByComma() {
        List<Integer> parsed = Parser.parse("1,2,3");
        assertThat(parsed.size()).isEqualTo(3);
        assertThat(parsed).isEqualTo(List.of(1, 2, 3));
    }

    @Test
    @DisplayName("콜론을 구분자로 하는 정수 문자열을 정수 리스트로 파싱")
    void parseByColon() {
        List<Integer> parsed = Parser.parse("1:2:3");
        assertThat(parsed.size()).isEqualTo(3);
        assertThat(parsed).isEqualTo(List.of(1, 2, 3));
    }

    @Test
    @DisplayName("커스텀 문자를 이용하여 정수 문자열을 정수 리스트로 파싱")
    void name() {
        List<Integer> parsed = Parser.parse("//;\n1;2;3");
        assertThat(parsed.size()).isEqualTo(3);
        assertThat(parsed).isEqualTo(List.of(1, 2, 3));
    }

    @Test
    @DisplayName("정규표현식 예약어가 구분자로 사용될 때 RuntimeException이 발생")
    void useDelimiterAsRegexComponent() {
        assertThatThrownBy(() -> Parser.parse("//.\n1.2.3")).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("숫자가 아닌 입력값을 받았을 때 RuntimeException이 발생")
    void useInputAsNonNumeric() {
        assertThatThrownBy(() -> Parser.parse("a,b,c")).isInstanceOf(RuntimeException.class);
    }
}
