package racingcar;

import racingcar.generator.NumberGenerator;

public class TestNumberGenerator implements NumberGenerator {
    private final int numberToReturn;

    public TestNumberGenerator(int numberToReturn) {
        this.numberToReturn = numberToReturn;
    }

    @Override
    public int generate() {
        return numberToReturn;
    }
}
