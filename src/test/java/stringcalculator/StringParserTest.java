package stringcalculator;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringParserTest {
	@Test
	@DisplayName("default 구분자 테스트")
	public void parseDefaultDelimiterTest() {
		String input = "10,2,3";
		List<Integer> result = StringParser.parse(input);
		Assertions.assertThat(result).containsExactly(10, 2, 3);

		input = "1:2:3";
		result = StringParser.parse(input);
		Assertions.assertThat(result).containsExactly(1, 2, 3);

		input = "1:2,3";
		result = StringParser.parse(input);
		Assertions.assertThat(result).containsExactly(1, 2, 3);

		input = "1,2:3,10";
		result = StringParser.parse(input);
		Assertions.assertThat(result).containsExactly(1, 2, 3, 10);

		input = "1,,3";
		result = StringParser.parse(input);
		Assertions.assertThat(result).containsExactly(1, 0, 3);

		input = "1, ,3";
		result = StringParser.parse(input);
		Assertions.assertThat(result).containsExactly(1, 0, 3);
	}

	@Test
	@DisplayName("custom 구분자 테스트")
	public void parseCustomDelimiterTest() {
		String input = "//;\n1;2;3";
		List<Integer> result = StringParser.parse(input);
		Assertions.assertThat(result).containsExactly(1, 2, 3);
		input = "//;\n1,2,3";
		result = StringParser.parse(input);
		Assertions.assertThat(result).containsExactly(1, 2, 3);
		input = "//;\n1:2:3";
		result = StringParser.parse(input);
		Assertions.assertThat(result).containsExactly(1, 2, 3);
		input = "//;\n1;2:3,4";
		result = StringParser.parse(input);
		Assertions.assertThat(result).containsExactly(1, 2, 3, 4);

	}

	@Test
	@DisplayName("Error input 테스트")
	public void parseErrorInputTest() {
		Assertions.assertThatThrownBy(() -> StringParser.parse("//n1;2;3"))
			.isInstanceOf(RuntimeException.class);

		Assertions.assertThatThrownBy(() -> StringParser.parse("//,;\n1,2,3"))
			.isInstanceOf(RuntimeException.class);

		Assertions.assertThatThrownBy(() -> StringParser.parse("1 1:2:3"))
			.isInstanceOf(RuntimeException.class);

		Assertions.assertThatThrownBy(() -> StringParser.parse("//\n1;2:3,4"))
			.isInstanceOf(RuntimeException.class);

		Assertions.assertThatThrownBy(() -> StringParser.parse("1,a,3"))
			.isInstanceOf(RuntimeException.class);

		Assertions.assertThatThrownBy(() -> StringParser.parse("1,-2,3"))
			.isInstanceOf(RuntimeException.class);
	}
}
