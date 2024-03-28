package view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import model.Car;
import model.RacingGame;

public class RacingGameView {
    private final Scanner sc = new Scanner(System.in);

    public String getCarNameInput() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return sc.nextLine();
    }

    public int getNumberInput() {
        System.out.println("시도할 회수는 몇 회인가요?");
        return sc.nextInt();
    }

    public void printResultMessage() {
        System.out.println("실행 결과");
    }

    public void printCarResult(List<Car> cars) {
        cars.forEach(car -> {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        });
        System.out.println();
    }

    public void printWinnerMessage(RacingGame racingGame) {
        System.out.println(
            racingGame.getWinners().stream()
            .map(Car::getName)
            .collect(Collectors.joining(", "))
            + "가 최종 우승했습니다.");
    }

    public void printErrorMessage(String message) {
        System.out.println("[ERROR]: " + message);
    }
}
