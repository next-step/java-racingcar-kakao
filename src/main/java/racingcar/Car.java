package racingcar;

public class Car {

    private final String name;
    private int position = 1;

    public static final int MAX_NAME_LENGTH = 5;

    public Car(String name) {
        validateCarName(name);
        this.name = name;
    }

    private static void validateCarName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(DiceResult diceResult) {
        if (diceResult.isMove()) {
            position++;
        }
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
    }
}
