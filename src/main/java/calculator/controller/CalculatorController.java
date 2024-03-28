package calculator.controller;

import calculator.Calculator;
import calculator.Delimiter;
import calculator.Validator;
import calculator.view.CalculatorView;

import java.util.*;

public class CalculatorController {
    private Calculator calculator;
    private Validator validator;
    private CalculatorView calculatorView;

    public CalculatorController() {
        calculator = new Calculator();
        validator = new Validator();
        calculatorView = new CalculatorView();
    }

    public void start() {
        Delimiter delimiter = new Delimiter();

        String expression = calculatorView.getExpression();

        expression = delimiter.findCustomOperator(expression);
        validator.validate(expression, delimiter);

        List<Integer> numberList = delimiter.split(expression);

        int result = calculator.calculate(numberList);

        calculatorView.printResult(result);
    }
}
