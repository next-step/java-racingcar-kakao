package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {
	private static final String DEFAULT_DELIMITER = ",:";

	public int calculate(String numberSequence) {
		if(Objects.isNull(numberSequence) || numberSequence.isEmpty()){
			return 0;
		}

		return parse(numberSequence)
			.stream()
			.reduce(0, Integer::sum);
	}

	private List<Integer> parse(String numberSequence) {
		String pattern = "(//(.+)\\n)?(.*)";

		Pattern regex = Pattern.compile(pattern);
		Matcher matcher = regex.matcher(numberSequence);

		StringBuilder sb = new StringBuilder(DEFAULT_DELIMITER);

		if (matcher.find() && Objects.nonNull(matcher.group(2))) {
			sb.append(matcher.group(2));
		}

		String numbers = matcher.group(3);
		return Arrays.stream(numbers.split("[" + sb + "]"))
			.map(Integer::parseInt)
			.collect(Collectors.toList());
	}
}
