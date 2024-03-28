package calculator.view;

import java.util.Scanner;

public class CalculatorView {
    private Scanner scanner;

    public CalculatorView() {
        scanner = new Scanner(System.in);
    }

    public String getExpression() {
        System.out.print("계산식을 입력하세요: ");
        return scanner.nextLine();
    }

    public void printResult(int result) {
        System.out.println("계산 결과는 " + result + "입니다.");
    }
}
