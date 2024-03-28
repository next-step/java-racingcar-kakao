package racinggame;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public final class ConsoleView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static List<String> getCarNames() {
        printCarNamesMessage();
        String names = SCANNER.nextLine();
        return Arrays.stream(names.split(","))
                .collect(Collectors.toList());
    }

    private static void printCarNamesMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public static int getTrial() {
        printTrialMessage();
        return Integer.parseInt(SCANNER.nextLine());
    }

    private static void printTrialMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printResult(List<String> rounds, List<String> winners) {
        printRoundMessage(rounds);
        printWinnerMessage(winners);
    }

    private static void printRoundMessage(List<String> rounds) {
        System.out.println("\n실행 결과");
        rounds.forEach(System.out::println);
    }

    private static void printWinnerMessage(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }
}