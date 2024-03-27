package racinggame;

import java.util.stream.Collectors;

public final class Application {
    public static void main(String[] args) {
        RacingGame game = RacingGame.of(
                Cars.of(ConsoleView.getCarNames().stream()
                        .map(Car::of)
                        .collect(Collectors.toList())),
                ConsoleView.getTrial()
        );
        game.run();
        ConsoleView.printResult(game.rounds(), game.winners());
    }
}