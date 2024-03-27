package service;

import java.util.Arrays;
import java.util.List;

public class RacingService {
    public List<String> extractCarNames(String input) {
        return Arrays.asList(input.split(","));
    }

    public int validateTryNumber(int tryNumber) {
        if (tryNumber < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
        return tryNumber;
    }
}
