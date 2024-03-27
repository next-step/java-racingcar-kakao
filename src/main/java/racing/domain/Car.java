package racing.domain;

public class Car {

    private final int MAX_NAME_LENGTH = 5;

    private final String name;
    private final CarEngine carEngine;
    private int position;

    public Car(String name, CarEngine carEngine) {
        validateName(name);
        this.name = name;
        this.carEngine = carEngine;
        this.position = 0;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Car name cant be blank.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("Car name length should be below 6.");
        }
    }

    public void move() {
        if (carEngine.canMove()) {
            this.position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
