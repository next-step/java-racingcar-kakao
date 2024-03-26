package calculator;

public class Calculator {

    private final Validator validator;

    public Calculator() {
        this.validator = new Validator();
    }

    public int sum (String [] tokens){
        int sum = 0;
        for (int i = 0; i < tokens.length; i++) {
            sum += validator.check(tokens[i]);
        }
        return sum;
    }
}
