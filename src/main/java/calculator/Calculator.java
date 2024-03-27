package calculator;

import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

    private final Delimiters delimiters;

    public InputProcessor inputProcessor;

    public Calculator() {
        this.delimiters = new Delimiters();
        this.inputProcessor = new InputProcessor();
    }

    public int add(String input) {
        input = input.replace("\\n", "\n");
        inputProcessor.validateInput(input);
        inputProcessor.parseCustomDelimiter(input).ifPresent(delimiters::addCustomDelimiter);
        List<Integer> numbers = parseNumber(input);
        return numbers.stream()
            .mapToInt(Integer::intValue)
            .sum();
    }

    private List<Integer> parseNumber(String input) {
        input = input.replaceAll("//(.*)\n", "");
        return delimiters.split(input).stream()
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }
}
