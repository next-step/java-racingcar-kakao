package controller;

import domain.RacingGame;
import view.InputValidator;
import view.View;

import java.util.Arrays;

public class RacingController {

    RacingGame racingGame;
    private final View view;
    private final InputValidator inputValidator;

    public RacingController() {
        view = new View();
        inputValidator = new InputValidator();
    }

    public void run() {
        boolean flag = false;
        while (!flag) {
            flag = isCorrectInput();
        }
        view.displayTryCount();
        int cnt = Integer.parseInt(view.input());
        view.displayResult();
        while (cnt-- > 0) {
            racingGame.move();
            view.displayMoveResult(racingGame.cars);
        }
        view.displayWinners(racingGame.selectWinners());
    }

    private boolean isCorrectInput(){
        view.displayInputCarName();
        String [] names = inputValidator.createCarsFromUserInput(view.input());
        if(names!=null){
            racingGame = new RacingGame(names);
            return true;
        }
        return false;
    }
}
