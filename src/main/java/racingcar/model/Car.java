package racingcar.model;

public class Car {

    private static final int MOVEMENT_THRESHOLD = 3;
    public int position;
    public String name;

    public Car(){
    }

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void checkForwardMotion(int number) {
        if (number > MOVEMENT_THRESHOLD) {
            position++;
        }
    }
}
