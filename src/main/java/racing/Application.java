package racing;

import racing.config.Constant;
import racing.controller.Controller;
import racing.domain.CarEngine;
import racing.domain.CarFactory;
import racing.infra.RandomCarEngine;
import racing.view.View;

public class Application {
    public static void main(String[] args) {
        CarEngine generator = new RandomCarEngine(-1, Constant.CAR_MOVE_THRESHOLD);
        View view = new View();
        CarFactory carFactory = new CarFactory(generator);
        Controller controller = new Controller(view, carFactory);
        controller.play();
    }
}
