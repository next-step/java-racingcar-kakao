package racinggame.domains;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public final class Cars {
    private final List<Car> values;

    public Cars(List<Car> values) {
        validate(values);
        this.values = values;
    }

    private void validate(List<Car> cars) {
        Set<Car> carSet = new HashSet<>(cars);
        if (carSet.size() != cars.size()) {
            throw new InputMismatchException("자동차 이름은 고유해야합니다.");
        }
    }

    public static Cars of(List<String> carNames) {
        return new Cars(carNames.stream()
                .map(Car::of)
                .collect(Collectors.toList()));
    }

    public List<Car> values() {
        return values;
    }

    public List<Car> winners() {
        Car winner = values.stream()
                .max(Car::compareOffset)
                .get();
        return values.stream()
                .filter(car -> car.at(winner.offset()))
                .collect(Collectors.toList());
    }
}
