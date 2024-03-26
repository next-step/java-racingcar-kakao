package calculator;

import java.util.Objects;

public class StringCalculator {
	public int calculate(String numberSequence) {
		if(Objects.isNull(numberSequence) || numberSequence.isEmpty()){
			return 0;
		}
		return Integer.parseInt(numberSequence);
	}
}
