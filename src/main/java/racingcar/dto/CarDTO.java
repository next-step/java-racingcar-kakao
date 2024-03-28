package racingcar.dto;

import racingcar.model.Car;
import racingcar.model.Name;
import racingcar.model.Position;

public class CarDTO {

    private final Name name;
    private final Position position;

    private CarDTO(final Name name, final Position position) {
        this.name = name;
        this.position = position;
    }

    public static CarDTO from(final Car car) {
        return new CarDTO(car.getName(), car.getPosition());
    }

    public String getName() {
        return name.getValue();
    }

    public int getPosition() {
        return position.getValue();
    }
}
