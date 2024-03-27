package racingcar;

public class Car {

    private static final int NAME_LENGTH_LIMIT = 5;

    private final String name;
    private int position = 1;

    public Car(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("이름은 5글자 이하만 가능합니다.");
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        position++;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
    }
}
