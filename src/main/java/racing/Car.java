package racing;

public class Car {

    public static final int MAX_CAR_NAME_LENGTH = 5;
    public static final int MOVE_FORWARD_THRESHOLD = 4;
    private final String name;
    private int position;

    public Car(String name) {
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public void moveForward(int num) {
        if (num >= MOVE_FORWARD_THRESHOLD) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String display() {
        return name + " : " + "-".repeat(position + 1);
    }

    public void moveForward(RandomStrategy rs) {
        moveForward(rs.generateRandomNumber());
    }
}
