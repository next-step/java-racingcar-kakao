package racingcar.model;

import java.util.LinkedList;
import java.util.List;

public class CustomNumberGenerator implements NumberGenerator{

    private final LinkedList<Integer> numbers;

    public CustomNumberGenerator(final List<Integer> numbers) {
        this.numbers = new LinkedList<>(numbers);
    }

    @Override
    public int generate() {
        return numbers.removeFirst();
    }
}
