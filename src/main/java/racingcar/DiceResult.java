package racingcar;

public class DiceResult {

    public static final int MOVE_BOUND = 4;
    private final int diceNum;

    public DiceResult(int diceNum) {
        validateDiceSize(diceNum);
        this.diceNum = diceNum;
    }

    private void validateDiceSize(int diceNum) {
        if (diceNum < 0 || diceNum > 9) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isMove() {
        return this.diceNum >= MOVE_BOUND;
    }
}
