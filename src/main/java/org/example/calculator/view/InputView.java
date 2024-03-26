package org.example.calculator.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);

    public String getInputString() {
        System.out.println("inputString을 입력하세요 : ");
        String inputString = sc.nextLine();
        return inputString.replace("\\n", "\n");
    }
}
