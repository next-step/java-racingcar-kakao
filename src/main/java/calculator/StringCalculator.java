package calculator;

import java.util.Arrays;
import java.util.Objects;

public class StringCalculator {
	private static final String DEFAULT_DELIMITER = "[,:]";

	public int calculate(String numberSequence) {
		if(Objects.isNull(numberSequence) || numberSequence.isEmpty()){
			return 0;
		}

		String[] numbers = numberSequence.split(StringCalculator.DEFAULT_DELIMITER);
		return Arrays.stream(numbers)
			.mapToInt(Integer::parseInt)
			.reduce(0, Integer::sum);
	}
}
