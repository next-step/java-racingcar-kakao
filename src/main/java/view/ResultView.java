package view;

import java.util.List;
import java.util.StringJoiner;

import model.Player;

public class ResultView {
    public static void printCars(List<Player> playerList) {
        playerList.forEach(
            player -> System.out.println(Player.makeCarPrint(player))
        );
        System.out.println();
    }

    public static void printWinners(List<String> playerNameList) {
        StringJoiner joiner = new StringJoiner(",");
        for (String playerName : playerNameList) {
            joiner.add(playerName);
        }

        System.out.println(joiner + " 가 최종 우승했습니다.");
    }

    public static void printGameStart() {
        System.out.println("실행 결과");
    }

}
