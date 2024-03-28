package racingcar.view;

import racingcar.model.Car;

import java.util.List;
import java.util.Scanner;

public class View {
	private final Scanner scanner;

	public View() {
		scanner = new Scanner(System.in);
	}

	public String input() {
		if (scanner.hasNext()) {
			return scanner.next();
		}
		scanner.next();
		return "";
	}

	public int requestInputTryCount() {
		System.out.println("시도할 회수는 몇회인가요?");
		return Integer.parseInt(input());
	}

	public String requestInputCarName() {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		return input();
	}

	public void displayStart() {
		System.out.println("\n" + "실행 결과");
	}

	public void displayResult(List<List<Integer>> gameResult, List<Car> cars) {
		for (List<Integer> result : gameResult) {
			displayMoveHistory(result, cars);
		}
		System.out.println();
	}

	public void displayMoveHistory(List<Integer> result, List<Car> cars) {
		for (int i = 0; i < result.size(); i++) {
			System.out.println(cars.get(i).getName() + " : " + "-".repeat(result.get(i)));
		}
		System.out.println();
	}

	public void displayWinners(List<String> winners) {
		System.out.print(String.join(", ", winners) + "가 최종 우승했습니다.");
	}
}
