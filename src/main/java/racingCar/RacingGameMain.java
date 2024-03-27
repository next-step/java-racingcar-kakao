package racingCar;

import racingCar.domain.RacingGame;
import racingCar.view.InputView;
import racingCar.view.OutputView;

public class RacingGameMain {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        outputView.printGuide();
        String carNames = inputView.getNames();

        outputView.printTryCount();
        int tryCount = inputView.getNumber();

        playGame(new RacingGame(carNames, tryCount));
    }

    private static void playGame(RacingGame game) {
        outputView.printResultGuide();

        while (!game.isGameEnd()) {
            game.race();
            outputView.printResult(game.getCars());
        }

        outputView.printWinners(game.getWinners());
    }
}
