package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_STEP_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static String readCarNames() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        return SCANNER.nextLine();
    }

    public static int readStepCount() {
        System.out.println(INPUT_STEP_COUNT_MESSAGE);
        return SCANNER.nextInt();
    }
}
