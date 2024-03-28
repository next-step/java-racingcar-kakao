package calculator;

import java.util.Arrays;

public class Calculator {
	private static final int ZERO = 0;

	private final Parser parser;

	public Calculator() {
		this.parser = new Parser();
	}

	public int calculate(String input) {
		if (input == null || input.isEmpty()) {
			return 0;
		}

		return this.sum(parser.parseInput(input));
	}

	public int sum(String[] tokens) {
		return Arrays.stream(tokens)
			.mapToInt(parser::strToInt)
			.peek(this::isMinus)
			.sum();
	}

	private void isMinus(int num) {
		if (num < ZERO) {
			throw new IllegalArgumentException("음수 입니다.");
		}
	}
}
