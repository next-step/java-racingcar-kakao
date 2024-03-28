package racinggame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGame {
    private final Cars cars;
    private final int trial;
    private final List<String> rounds;
    private final List<String> winners;

    public static RacingGame of(Cars cars, int trial) {
        return new RacingGame(cars, trial);
    }

    private RacingGame(Cars cars, int trial) {
        this.cars = cars;
        this.trial = trial;
        this.rounds = new ArrayList<>();
        this.winners = new ArrayList<>();
    }

    public List<String> rounds() {
        return Collections.unmodifiableList(rounds);
    }

    public List<String> winners() {
        return Collections.unmodifiableList(winners);
    }

    public void run() {
        for (int i = 0; i < trial; i++) {
            cars.moveAll();
            rounds.add(cars.statusAll());
        }
        lineUpCars();
    }

    private void lineUpCars() {
        int maxOffset = cars.list().stream()
                .mapToInt(Car::offset)
                .max()
                .orElse(0);
        cars.list().stream()
                .filter(e -> e.offset() == maxOffset)
                .forEach(e -> winners.add(e.name()));
    }
}
