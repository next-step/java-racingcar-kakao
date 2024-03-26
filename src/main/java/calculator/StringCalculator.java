package calculator;

import java.util.Objects;

public class StringCalculator {
	private final NumberCaculator calculator = new NumberCaculator();
	private final StringParser parser = new StringParser();

	public int calculate(String numberSequence) {
		if (Objects.isNull(numberSequence) || numberSequence.isEmpty()){
			return 0;
		}

		return calculator.calculate(parser.parse(numberSequence));
	}
}
