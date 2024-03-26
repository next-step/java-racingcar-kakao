package string_add_calculator;

import java.util.List;

public class Calculator {
    public Number sum(List<Number> numbers) {
        return numbers.stream()
                .reduce(new Number(0), Number::add);
    }
}
