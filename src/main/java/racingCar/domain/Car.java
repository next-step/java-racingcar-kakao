package racingCar.domain;

public class Car {

    private static final int MAX_NAME_LENGTH = 5;
    private static final int MOVE_THRESHOLD = 3;

    private String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
        }
    }

    public void move(int number) {
        if (number > MOVE_THRESHOLD) {
            this.position++;
        }
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return name;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
    }
}
