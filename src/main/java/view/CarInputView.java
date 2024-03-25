package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CarInputView {
    private final Scanner sc = new Scanner(System.in);

    public String getCarNameInput() {
        return sc.nextLine();
    }

    public int getNumberInput() {
        return sc.nextInt();
    }

    public List<String> getCarNames(String input) {
        List<String> carNames = Arrays.asList(input.split(","));
        for (String carName : carNames) {
            validateCarName(carName);
        }
        return carNames;
    }


    private void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }
}
