package racing.domain;

public class Car {

    private final String name;
    private final CarEngine carEngine;
    private int position;

    public Car(String name, CarEngine carEngine) {
        this.position = 0;
        this.carEngine = carEngine;
        this.name = name;
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
