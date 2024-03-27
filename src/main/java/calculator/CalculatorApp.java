package calculator;

import calculator.domains.Adder;
import calculator.domains.Numbers;

public class CalculatorApp {
    public int calculate(String input) {
        if (input == null || input.isBlank()) {
            return 0;
        }
        return Adder.sum(Numbers.of(input).find());
    }
}
