package racing.support;

import racing.domain.CarEngine;

public class StubCarEngine implements CarEngine {

    private final boolean condition;

    public StubCarEngine(boolean condition) {
        this.condition = condition;
    }

    @Override
    public boolean canMove() {
        return condition;
    }
}
