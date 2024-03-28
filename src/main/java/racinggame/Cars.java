package racinggame;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class Cars {
    private final List<Car> list;

    public static Cars of(List<Car> cars) {
        return new Cars(cars);
    }

    private Cars(List<Car> cars) {
        list = Collections.unmodifiableList(cars);
        validateCars();
    }

    private void validateCars() {
        Set<Car> setForDuplicationCheck = new HashSet<>(list);
        if (list.size() != setForDuplicationCheck.size()) {
            throw new IllegalStateException("중복 참여된 자동차가 있습니다.");
        }
    }

    public List<Car> list() {
        return list;
    }

    public void moveAll() {
        list.forEach(Car::move);
    }

    public String statusAll() {
        StringBuilder sb = new StringBuilder();
        for (Car car : list) {
            sb.append(car.status()).append('\n');
        }
        return sb.toString();
    }
}
