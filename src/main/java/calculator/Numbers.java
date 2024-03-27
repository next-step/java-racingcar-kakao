package calculator;

import java.util.ArrayList;
import java.util.List;

public final class Numbers {
    private final List<Integer> list;

    public Numbers(List<Integer> numbers) {
        this.list = new ArrayList<>(numbers);
    }

    public static Numbers of(List<Integer> numbers) {
        return new Numbers(numbers);
    }

    public List<Integer> list() {
        return list;
    }
}
