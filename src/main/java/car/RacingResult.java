package car;

import java.util.ArrayList;
import java.util.List;

public class RacingResult {
    private final List<Car> cars;

    public RacingResult(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getWinners() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }

        return winners;
    }
}
