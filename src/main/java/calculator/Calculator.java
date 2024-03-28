package calculator;

import java.util.List;

public class Calculator {
    public int calculate(List<Integer> numberList) {
        return numberList.stream()
                .mapToInt(number -> number)
                .sum();
    }
}
