package racing;

public class Car {

    private static final int MOVE_THRESHOLD = 4;
    private int position;


    public Car(String name) {
        this.position = 0;
    }

    public void move(int condition) {
        if (condition >= MOVE_THRESHOLD) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
