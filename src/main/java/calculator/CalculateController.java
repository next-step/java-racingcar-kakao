package calculator;

public class CalculateController {

    private final Calculator calculator;
    private final Parser parser;

    public CalculateController() {
        this.calculator = new Calculator();
        this.parser = new Parser();
    }

    public int calculate (String input){

        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] tokens = parser.split(input);

        return calculator.sum(tokens);
    }
}
