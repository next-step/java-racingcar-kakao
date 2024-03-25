package racing_car;

public class DiceResult {

    private final int diceNum;

    public DiceResult(int diceNum) {
        validate(diceNum);
        this.diceNum = diceNum;
    }

    private void validate(int diceNum) {
        if (diceNum < 0 || diceNum > 9) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isMove() {
        return this.diceNum >= 4;
    }
}
