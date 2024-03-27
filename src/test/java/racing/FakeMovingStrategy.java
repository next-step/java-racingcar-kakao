package racing;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class FakeMovingStrategy implements MovingStrategy {

    private final List<Integer> numbers;
    private final AtomicInteger currentIndex = new AtomicInteger(0);

    public FakeMovingStrategy(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public int generateNumber() {
        return numbers.get(currentIndex.getAndIncrement() % numbers.size());
    }
}
