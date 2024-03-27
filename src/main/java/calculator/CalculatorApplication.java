package calculator;

import java.util.Scanner;

public class CalculatorApplication {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            InputProcessor inputProcessor = new InputProcessor();
            Calculator calculator = new Calculator();

            System.out.println("Enter the input: ");
            String input = scanner.nextLine();

            inputProcessor.validateInput(input);
            System.out.println(
                "Result: " + calculator.add(inputProcessor.parseCustomDelimiter(input).orElse("")));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
