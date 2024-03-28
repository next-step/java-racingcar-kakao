package racing.domain;

public class Car {

    private final CarName name;
    private final CarEngine carEngine;
    private int position;

    public Car(String name, CarEngine carEngine) {
        this.name = new CarName(name);
        this.carEngine = carEngine;
        this.position = 0;
    }

    public void move() {
        position += carEngine.getSpeed();
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name.getName();
    }

    public boolean locates(int position) {
        return this.position == position;
    }
}
