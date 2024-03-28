package view;

import racing.Car;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RacingGameView {

    public static String getCarNames() {
        System.out.println(Message.INPUT_CAR_NAMES);
        return getInput();
    }

    public static int getTryNums() {
        System.out.println(Message.INPUT_TRY_NUMS);
        int tryNums = Integer.parseInt(getInput());
        System.out.println();
        return tryNums;
    }

    public static String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void displayResult() {
        System.out.println(Message.RESULT);
    }

    public static void displayCars(List<Car> cars) {
        cars.forEach(car -> System.out.println(car.display()));
        System.out.println();
    }

    public static void displayWinners(List<Car> cars) {
        String winners = cars.stream().map(Car::getName).collect(Collectors.joining(", "));
        System.out.printf(Message.DISPLAY_WINNER_FMT, winners);
    }
}
