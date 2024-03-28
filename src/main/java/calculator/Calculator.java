package calculator;

public class Calculator {


    public Calculator() {
    }

    public int sum (String [] tokens){
        int sum = 0;

        for (String token : tokens) {
            sum += Validator.isPositiveInteger(token);
        }

        return sum;
    }
}
