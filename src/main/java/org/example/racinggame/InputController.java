package org.example.racinggame;

import java.util.Scanner;

public class InputController {

    private static final Scanner scanner = new Scanner(System.in);

    public int getTryCountFromUserInput() {
        System.out.println("시도할 회수는 몇 회인가요?");
        return scanner.nextInt();
    }

    public Cars getCarsFromUserInput() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분).");
        String inputCarNames = scanner.nextLine();
        return new Cars(inputCarNames);
    }
}
