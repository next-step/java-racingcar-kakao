package racingCar;

import java.util.List;
import racingCar.domain.Cars;

public class RacingGame {

    private static final NumberGenerator numberGenerator = new NumberGenerator();

    private int tryNo;
    private final Cars cars;

    public RacingGame(String carNames, int tryNo) {
        this.tryNo = tryNo;
        this.cars = new Cars(carNames);
    }

    public void race() {
        tryNo--;
        cars.move(numberGenerator);
    }

    public boolean isGameEnd() {
        return tryNo == 0;
    }

    public Cars getCars() {
        return cars;
    }

    public List<String> getWinners() {
        return cars.getWinners();
    }
}
