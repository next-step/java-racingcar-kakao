package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Numbers numbers = (Numbers) o;
        return Objects.equals(list, numbers.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }
}
