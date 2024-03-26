package stringcalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {
	private static final String DEFAULT_DELIMITER = ":|,";
	public static List<Integer> parse(String input) {
		String delimiter = DEFAULT_DELIMITER;
		Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
		if (matcher.find()) {
			delimiter += "|" + matcher.group(1);
			input = matcher.group(2);
		}

		List<Integer> result = new ArrayList<>();
		List<String> numbers = Arrays.stream(input.split(delimiter)).map(String::trim).toList();
		for (String number : numbers) {
			if (number == null || number.isEmpty()) {
				number = "0";
			}

			int parsedInt = Integer.parseInt(number);

			if (parsedInt < 0) {
				throw new RuntimeException();
			}

			result.add(parsedInt);
		}

		return result;
	}
}
