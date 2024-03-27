package racingcar.model;

import java.util.Random;

public class RacingCar {

    private static final int MOVE_MIN_LIMIT = 4;
    private static final int MOVE_MAX_LIMIT = 9;

    private final String name;
    private int position = 0;

    public RacingCar(String name) {
        this.name = name;
    }

    public void moveIfNumBig(int num) {
        if (moveOrNot(num)) {
            this.position++;
        }
    }

    public void move() {
        int num = makeRandomNum();
        moveIfNumBig(num);
    }

    public boolean moveOrNot(int num) {
        return MOVE_MIN_LIMIT <= num && num <= MOVE_MAX_LIMIT;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private static int makeRandomNum() {
        Random random = new Random();
        return random.nextInt(9);
    }
}
