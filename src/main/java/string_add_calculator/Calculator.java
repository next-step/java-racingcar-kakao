package string_add_calculator;

import java.util.List;

public class Calculator {

    public Number sum(List<Number> numbers) {
        return numbers.stream()
                .reduce(new Number(0), Number::add);
    }

    public Number sum(String input) {
        List<Number> numbers = Parser.parseNumbers(input);
        return sum(numbers);
    }
}
