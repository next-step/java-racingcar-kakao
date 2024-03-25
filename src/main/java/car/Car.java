package car;

public class Car {
    private int position;
    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void run(int randomNumber) {
        if (randomNumber >= 4) {
            position += 1;
        }
    }
}
