package racinggame;

import racinggame.domains.RacingCarGame;

public class RacingCarApplication {
    public RacingCarApplication() {
    }

    public void run() {
        ConsoleView.printCarNamesInputPrompt();
        RacingCarGame racingCarGame = RacingCarGame.of(ConsoleView.getCarNamesInput());

        ConsoleView.printTrialInputPrompt();
        int trialInput = ConsoleView.getTrialInput();

        ConsoleView.printResultPrompt();
        for (int i = 0; i < trialInput; i++) {
            racingCarGame.processTurn();
            ConsoleView.printCarOffset(racingCarGame);
        }
        ConsoleView.printResult(racingCarGame);
    }

    public static void main(String[] args) {
        new RacingCarApplication().run();
    }
}
