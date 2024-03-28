package racingcar.model;

import java.util.LinkedList;
import java.util.List;

public class CustomCarMoveStrategy implements CarMoveStrategy{

    private final LinkedList<Boolean> moves;

    public CustomCarMoveStrategy(final List<Boolean> moves) {
        this.moves = new LinkedList<>(moves);
    }

    @Override
    public boolean evaluateMove() {
        return moves.removeFirst();
    }
}
