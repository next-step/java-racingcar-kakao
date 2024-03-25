package racing_car;

import racing_car.view.Input;
import racing_car.view.Output;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    private final Dice dice = new Dice();

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
        List<DiceResult> diceResults = new ArrayList<>();
        for (int j = 0; j < cars.count(); j++) {
            diceResults.add(new DiceResult(dice.throwOnce()));
        }
        cars.move(diceResults);
        Output.printGameProcessResult(cars.toString());
    }
}
