package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
	private static final Pattern customDelimiterPattern = Pattern.compile("//(.)\n(.*)");

	public String[] parseInput(String input) {
		Matcher matcher = customDelimiterPattern.matcher(input);

		if (matcher.find()) {
			String customDelimiter = matcher.group(1);
			return matcher.group(2).split(customDelimiter);
		}

		return input.split("[,:;]");
	}

	public Integer strToInt(String input) {
		try {
			return Integer.parseInt(input);
		} catch (Exception e) {
			throw new IllegalArgumentException("숫자가 아닌 값이 들어가있습니다.");
		}
	}
}
