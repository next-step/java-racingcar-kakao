package carrace.domain;

public class Car {

    private final String name;
    private int position = 1;

    public Car(String name) {
        this.name = name;
        validateName();
    }

    private void validateName() {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5자이하여야 합니다.");
        }

        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차의 이름은 공백이 아니여야 합니다.");
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward() {
        position++;
    }
}
