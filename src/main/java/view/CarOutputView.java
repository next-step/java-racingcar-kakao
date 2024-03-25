package view;

import car.RacingResult;

import java.util.List;

public class CarOutputView {
    public void printCarNameMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public void printTryNumberMessage() {
        System.out.println("시도할 회수는 몇 회인가요?");
    }

    public void printResultMessage() {
        System.out.println("실행 결과");
    }

    public void printCarResult(List<String> carMessages) {
        carMessages.forEach(System.out::println);
        System.out.println();
    }

    public void printWinnerMessage(RacingResult result) {
        StringBuilder sb = new StringBuilder();
        result.getWinners().forEach(car -> sb.append(car.getName()).append(", "));
        System.out.println(sb.substring(0, sb.length() - 2) + "가 최종 우승했습니다.");
    }

    public void printErrorMessage(String message) {
        System.out.println("[ERROR]: " + message);
    }
}
