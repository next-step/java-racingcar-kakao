package calculator;

import java.util.List;

public class NumberCaculator {
	public int calculate(List<Integer> numbers) {
		return numbers
			.stream()
			.reduce(0, Integer::sum);
	}
}
