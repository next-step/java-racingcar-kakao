package org.example;

public class Car {

    private static final int FORWARD_THRESHOLD = 4;
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void forward(int randomNumber) {
        if (randomNumber >= FORWARD_THRESHOLD) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
