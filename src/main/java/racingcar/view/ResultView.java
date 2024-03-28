package racingcar.view;

import racingcar.Car;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static void printGameProcessTitle() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printGameBoard(List<Car> cars) {
        cars.forEach(car -> ResultView.printCarProcessLine(car.getName(), car.getPosition()));
        System.out.println();
    }

    private static void printCarProcessLine(String carName, int position) {
        System.out.println(carName + " : " + "-".repeat(position));
    }

    public static void printGameWinner(List<Car> winners) {
        List<String> winnerNames = winners.stream().map(Car::getName).collect(Collectors.toList());
        System.out.println(String.join(", ", winnerNames) + "가 최종 우승했습니다.");
    }
}
