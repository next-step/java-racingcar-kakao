package strcalc;

public class StringCalculator {

    public int add(String input) {
        return add(CalculatorParser.parseInput(input));
    }

    int add(String text, String delimiter) {
        if (text.isEmpty()) {
            return 0;
        }
        String[] numbersArray = text.split(delimiter);
        return sum(numbersArray);
    }

    private int sum(String[] numbersArray) {
        int sum = 0;
        for (String number : numbersArray) {
            sum += parseInt(number);
        }
        return sum;
    }

    private int parseInt(String number) {
        int val = Integer.parseInt(number);
        if (val < 0) {
            throw new RuntimeException("Negative integer");
        }
        return val;
    }

    int add(CalculatorInput calculatorInput) {
        return add(calculatorInput.getText(), calculatorInput.getDelimiter());
    }
}