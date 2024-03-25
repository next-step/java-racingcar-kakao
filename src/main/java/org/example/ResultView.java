package org.example;

public class ResultView {
    public static void printWinners(Cars cars) {
        System.out.println(getWinners(cars) + "가 최종 우승했습니다.");
    }

    public static void playRacingCarGame(int tryCount, Cars cars) {
        for (int i = 0; i < tryCount; i++) {
            cars.move();
            printCarPositions(cars);
        }
    }

    public static String getWinners(Cars cars) {
        return String.join(", ", cars.getWinners());
    }

    public static void printCarPositions(Cars cars) {
        System.out.println();
        for (Car car : cars.getCarList()) {
            String sb = car.getName() +
                    " : " +
                    "-".repeat(car.getPosition());
            System.out.println(sb);
        }
    }
}
