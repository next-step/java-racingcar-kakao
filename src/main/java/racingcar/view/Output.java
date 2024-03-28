package racingcar.view;

import java.util.List;

public class Output {

    public static void printGameProcessTitle() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printCarProcessLine(String carName, int position) {
        System.out.println(carName + " : " + "-".repeat(position));
    }

    public static void printGameWinner(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }
}
