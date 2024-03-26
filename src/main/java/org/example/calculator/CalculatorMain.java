package org.example.calculator;

import java.util.Scanner;

public class CalculatorMain {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String inputString = sc.nextLine();
        System.out.println("inputString = " + inputString);

        String replacedInput = inputString.replace("\\n", "\n");
        Calculator calculator = new Calculator(replacedInput);
        int result = calculator.calculate();

        System.out.println("result = " + result);
    }
}
