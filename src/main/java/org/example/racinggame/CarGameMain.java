package org.example.racinggame;

public class CarGameMain {

    private static final InputController inputController = new InputController();

    public static void main(String[] args) {
        Cars cars = inputController.getCarsFromUserInput();
        int tryCount = inputController.getTryCountFromUserInput();

        System.out.println("실행 결과");
        playRacingCarGame(cars, tryCount);

        ResultView.printCarPositions(cars);
        ResultView.printWinners(cars);
    }

    private static void playRacingCarGame(Cars cars, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            cars.move();
            ResultView.printCarPositions(cars);
        }
    }
}
