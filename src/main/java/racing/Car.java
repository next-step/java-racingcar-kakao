package racing;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void moveForward(int num) {
        if (num >= 4) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String display() {
        return name + " : " + "-".repeat(position + 1);
    }
}
