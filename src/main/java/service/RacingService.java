package service;

import java.util.Arrays;
import java.util.List;

public class RacingService {
    public List<String> extractCarNames(String input) {
        List<String> carNames = Arrays.asList(input.split(","));
        carNames.forEach(this::validateCarName);
        return carNames;
    }

    public void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public int validateTryNumber(int tryNumber) {
        if (tryNumber < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
        return tryNumber;
    }
}
