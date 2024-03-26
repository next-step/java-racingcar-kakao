package view;

import java.util.Scanner;

import static model.Player.validate;

public class InputView {

    static Scanner sc = new Scanner(System.in);

    public static String getCarNames() {
        System.out.println("차입력 : ");
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
        System.out.println("몇번할까 : ");
        return Integer.parseInt(sc.nextLine());
    }
}
