package racing.domain;

public class Car {

    private final String name;
    private final CarEngine carEngine;
    private int position;

    public Car(String name, CarEngine carEngine) {
        this.name = name;
        this.carEngine = carEngine;
        this.position = 0;
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
