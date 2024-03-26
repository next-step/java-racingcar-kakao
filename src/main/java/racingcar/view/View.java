package racingcar.view;

import racingcar.model.Car;
import java.util.List;
import java.util.Scanner;

public class View {
    private final Scanner scanner;
    public View(){
        scanner = new Scanner(System.in);
    }

    public String input() {
        if (scanner.hasNext()) {
            return scanner.next();
        }
        scanner.next();
        return "";
    }

    public int displayTryCount (){
        System.out.print("시도할 회수는 몇회인가요?");
        return Integer.parseInt(input());
    }
    public String displayInputCarName (){
        System.out.print("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return input();
    }
    public void displayResult() {
        System.out.println("실행 결과");
    }

    public void displayMoveResult(List <Car> cars) {
        for (Car car: cars) {
            System.out.print(car.name + " : " );
            displayMoveDistance(car.position);
            System.out.println();
        }
        System.out.println();
    }

    public void displayMoveDistance (int position){
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
    }

    public void displayWinners(List<String> winners) {
        for (int i = 0; i < winners.size() - 1; i++) {
            System.out.print(winners.get(i)+", ");
        }
        System.out.print(winners.get(winners.size()-1)+"가 최종 우승했습니다.");
    }
}
