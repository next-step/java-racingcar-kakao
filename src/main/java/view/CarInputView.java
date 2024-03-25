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
        carNames.forEach(this::validateCarName);
        return carNames;
    }


    private void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    private void validateTryNumber(int tryNumber) {
        if (tryNumber < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
}
