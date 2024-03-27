package calculator;

import java.util.Scanner;

public class CalculatorApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the input: ");
        String input = scanner.nextLine();

        CalculatorController calculatorController = new CalculatorController();
        int result = calculatorController.add(input);

        System.out.println("Result: " + result);
        scanner.close();
    }
}
