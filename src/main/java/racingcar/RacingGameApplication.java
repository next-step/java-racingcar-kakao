package racingcar;

import racingcar.dto.CarDTO;
import racingcar.model.RacingGame;
import racingcar.model.RandomCarMoveStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.stream.Collectors;

public class RacingGameApplication {

    public static void main(String[] args) {
        final RacingGame racingGame = initializeGame();
        runGame(racingGame);
        OutputView.printWinner(racingGame.getWinnerNames());
    }

    private static RacingGame initializeGame() {
        final String carNames = InputView.readCarNames();
        final int stepCount = InputView.readStepCount();
        return new RacingGame(carNames, new RandomCarMoveStrategy(), stepCount);
    }

    private static void runGame(final RacingGame racingGame) {
        OutputView.printPlayTitle();
        while (!racingGame.isEnd()) {
            racingGame.play();
            OutputView.printRoundResult(racingGame.getCars().stream().map(CarDTO::from).collect(Collectors.toUnmodifiableList()));
        }
    }
}
