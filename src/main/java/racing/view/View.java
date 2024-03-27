package racing.view;

import java.util.List;
import java.util.Scanner;

public class View {
    private final Scanner scanner;

    public View() {
        this.scanner = new Scanner(System.in);
    }

    public String promptCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.next();
    }

    public int promptRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }

    public void printResultHeader() {
        System.out.println("실행 결과");
    }

    public void printResult(String name, int position) {
        System.out.printf("%s : %s\n", name, "-".repeat(position + 1));
    }

    public void printBlankLine() {
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.print(String.join(", ", winners));
        System.out.println("가 최종 우승했습니다.");
    }
}
