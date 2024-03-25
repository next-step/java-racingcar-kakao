package controller;

import racing.Car;
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
        tryNums = RacingGameView.getTryNums();
        racingGame = new RacingGame(carNames);
    }

    private  void playround(RacingGame racingGame, int tryNums) {
        RacingGameView.displayResult();
        RacingGameView.displayCars(racingGame.getCars());
        IntStream.range(0, tryNums).forEach(i -> {
            racingGame.moveCars();
            RacingGameView.displayCars(racingGame.getCars());
        });
    }

    private  void result(RacingGame racingGame) {
        List<Car> winners = racingGame.winners();
        RacingGameView.displayWinners(winners);
    }
}
