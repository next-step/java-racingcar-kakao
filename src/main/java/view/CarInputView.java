package view;

import java.util.Scanner;

public class CarInputView {
    private final Scanner sc = new Scanner(System.in);

    public String getCarNameInput() {
        return sc.nextLine();
    }

    public int getNumberInput() {
        return sc.nextInt();
    }
}
