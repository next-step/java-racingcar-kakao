package calculator;

import java.util.Objects;

public class StringCalculator {
	public static final int DEFAULT_VALUE = 0;

	private final NumberCalculator calculator = new NumberCalculator();
	private final StringParser parser = new StringParser();

	public int calculate(String numberSequence) {
		if (Objects.isNull(numberSequence) || numberSequence.isEmpty()){
			return DEFAULT_VALUE;
		}

		return calculator.calculate(parser.parse(numberSequence));
	}
}
