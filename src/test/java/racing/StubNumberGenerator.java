package racing;

public class StubNumberGenerator implements NumberGenerator {

    private final int condition;

    public StubNumberGenerator(int condition) {
        this.condition = condition;
    }

    @Override
    public int generate() {
        return condition;
    }
}
