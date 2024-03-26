package stringcalculator;


import java.util.List;

public class StringCalculator {
	public static int calculate(String input) {
		List<Integer> integerList = StringParser.parse(input);
		int sum = 0;
		for (Integer i : integerList) {
			sum += i;
		}
		return sum;
	}
}
