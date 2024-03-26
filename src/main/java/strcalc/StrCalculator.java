package strcalc;

public class StrCalculator {

    public int add(String input) {
        return add(CalcParser.parseInput(input));
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
            sum += Integer.parseInt(number);
        }
        return sum;
    }

    int add(CalcInput calcInput) {
        return add(calcInput.getText(), calcInput.getDelimiter());
    }
}