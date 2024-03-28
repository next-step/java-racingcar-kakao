package racingcar.model;

public class Car {
    private static final int MOVEMENT_THRESHOLD = 3;
    private static final int MAX_NAME_LENGTH = 5;
    private static final String EMPTY_NAME = "";
    private int position;
    private String name;

    public Car(){
        checkCarNameLength(EMPTY_NAME);
    }

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        checkCarNameLength(name);
        this.name = name;
        this.position = position;
    }

    private void checkCarNameLength(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름이 존재하지 않음");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름 길이 초과");
        }
    }

    public void decideMovement(int number) {
        if (number > MOVEMENT_THRESHOLD) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
