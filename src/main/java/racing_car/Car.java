package racing_car;

public class Car {

    private final String name;
    private int position = 1;

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
        this.name = name;
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
