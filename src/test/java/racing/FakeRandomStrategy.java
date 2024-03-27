package racing;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class FakeRandomStrategy implements RandomStrategy {

    private final List<Integer> numbers;
    private final AtomicInteger currentIndex = new AtomicInteger(0);

    public FakeRandomStrategy(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public int generateRandomNumber() {
        return numbers.get(currentIndex.getAndIncrement() % numbers.size());
    }
}
