package racingcar;

import racingcar.model.Car;
import racingcar.model.Name;
import racingcar.model.Position;

public class CarResponse {

    private final Name name;
    private final Position position;

    public CarResponse(final Car car) {
        this.name = car.getName();
        this.position = car.getPosition();
    }

    public String getName() {
        return name.getValue();
    }

    public int getPosition() {
        return position.getValue();
    }
}
