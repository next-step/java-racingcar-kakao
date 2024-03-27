package racingcar;

public class Car {
    public static final int MAX_NAME_LENGTH = 5;
    public static final int CAN_MOVE_BOUND = 4;

    private final String name;
    private int position = 1;

    public Car(String name) {
        validateCarName(name);
        this.name = name;
    }

    private static void validateCarName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 널 또는 빈 값이 될 수 없습니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름의 최대 길이는" + MAX_NAME_LENGTH + "입니다.");
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int randomNumber) {
        if (randomNumber >= CAN_MOVE_BOUND) {
            position++;
        }
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
    }
}
