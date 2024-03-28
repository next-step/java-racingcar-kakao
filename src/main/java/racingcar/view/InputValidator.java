package racingcar.view;

import java.util.Arrays;

public class InputValidator {
    public String[] createCarsFromUserInput(String input) {
        String [] carNames = input.split(",");
        wordLengthCheck(carNames);
        return carNames;
    }

    private void wordLengthCheck(String[] carNames) {
        Arrays.stream(carNames)
                .filter(name -> name.length() >=5)
                .findFirst()
                .ifPresent(name -> {
                    throw new IllegalArgumentException("문자의 길이가 5 이상입니다.");
                });
    }
}
