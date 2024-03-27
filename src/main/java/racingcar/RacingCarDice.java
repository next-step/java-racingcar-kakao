package racingcar;

import java.util.Random;

public class RacingCarDice {

    private static final Random random = new Random();
    private static final int DICE_SIZE = 10;
    private static final int MOVE_THRESHOLD = 4;

    public static int throwOnce() {
        return random.nextInt(DICE_SIZE);
    }

    public static boolean isMove(int diceNum) {
        if (diceNum < 0 || diceNum >= DICE_SIZE) {
            throw new IllegalArgumentException("잘못된 주사위 눈을 입력하였습니다.");
        }
        return diceNum >= MOVE_THRESHOLD;
    }
}
