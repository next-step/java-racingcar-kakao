package controller;

import racing.RacingGame;
import view.RacingGameView;

import java.util.List;
import java.util.stream.IntStream;

public class RacingGameController {

    private RacingGame racingGame;
    private int tryNums;

    public  void startGame() {
        setup();
        playround(racingGame, tryNums);
        result(racingGame);
    }

    private void setup() {
        String carNames = RacingGameView.getCarNames();
        while (carNames.isEmpty()) {
            carNames = RacingGameView.getCarNames();
        }
        while (true){
            if (getTryNums()) break;
        }
        racingGame = new RacingGame(carNames);
    }

    private boolean getTryNums() {
        try {
            tryNums = RacingGameView.getTryNums();
            return true;
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해주세요.");
        }
        return false;
    }

    private  void playround(RacingGame racingGame, int tryNums) {
        RacingGameView.displayResult();
        RacingGameView.displayCars(racingGame.getCarsPositionInfos());
        IntStream.range(0, tryNums).forEach(i -> {
            racingGame.moveCars();
            RacingGameView.displayCars(racingGame.getCarsPositionInfos());
        });
    }

    private  void result(RacingGame racingGame) {
        List<String> winners = racingGame.getWinners();
        RacingGameView.displayWinners(winners);
    }
}
