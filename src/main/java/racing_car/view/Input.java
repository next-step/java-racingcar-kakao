package racing_car.view;

import java.util.Scanner;

public class Input {

    private static Scanner scanner = new Scanner(System.in);

    public static String getRacingCarsLine() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    public static int getGameCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = scanner.nextLine();
        validate(input);
        return Integer.parseInt(input);
    }

    private static void validate(String input) {
        int count = Integer.parseInt(input);
        if (count < 0) {
            throw new IllegalArgumentException();
        }
    }
}
