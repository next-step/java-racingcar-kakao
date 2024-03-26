package view;

import java.util.Scanner;

import static model.Car.validate;

public class InputView {

    static Scanner sc = new Scanner(System.in);

    public static String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String userInput = sc.nextLine();
        validate(userInput);
        return userInput;

        // TODO : retry logic 구현했으나 indent 이슈로 deprecate
        /**
        while (true) {
            try {
                System.out.println("차입력 : ");
                String userInput = sc.nextLine();
                validate(userInput);
                return userInput;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
         */
    }


    public static int getTryNo() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(sc.nextLine());
    }
}
