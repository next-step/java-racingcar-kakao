package racingcar.model;

public class Car {
    private static final int MOVEMENT_THRESHOLD = 3;
    private static final int MAX_NAME_LENGTH = 5;
    private int position;
    private String name;

    public Car(){
    }

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        if(checkCarNameLength(name)){
            this.name = name;
            this.position = position;
        }
    }

    private boolean checkCarNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름 길이 초과");
        }
        return true;
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
