package org.example.racinggame.view;

import java.util.List;

public class OutputView {

    public void printWinners(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }

    public void printCarPositions(String positionString) {
        System.out.println(positionString);
    }

    public void printResult() {
        System.out.println();
        System.out.println("실행 결과");
    }
}
