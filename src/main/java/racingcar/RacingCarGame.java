package racingcar;

import racingcar.view.Input;
import racingcar.view.Output;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    public void startGame() {
        Cars cars = new Cars(Input.getRacingCarsLine());
        int count = Input.getGameCount();

        Output.printGameProcessTitle();
        Output.printGameProcessResult(cars.toString());
        for (int i = 0; i < count; i++) {
            playProcess(cars);
        }
        Output.printGameWinner(cars.decideWinner());
    }

    private void playProcess(Cars cars) {
        cars.move();
        Output.printGameProcessResult(cars.toString());
    }
}
