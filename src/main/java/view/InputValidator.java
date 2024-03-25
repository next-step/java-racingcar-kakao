package view;

import java.util.Arrays;
import java.util.List;

public class InputValidator {
    public String[] createCarsFromUserInput(String input) {
        String [] carNames = input.split(",");
        if(exceptionCheck(carNames)){
            return carNames;
        }
        return null;
    }

    private boolean exceptionCheck(String[] carNames){

        try {
            wordLengthCheck(carNames);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private void wordLengthCheck(String[] carNames) {
        Arrays.stream(carNames)
                .filter(name -> name.length() >=5)
                .findFirst()
                .ifPresent(name -> {
                    throw new IllegalArgumentException("길이 5 이상입니다.");
                });
    }
}
