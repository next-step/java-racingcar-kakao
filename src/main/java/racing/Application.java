package racing;

import racing.config.Constant;
import racing.controller.Controller;
import racing.domain.CarEngine;
import racing.infra.RandomCarEngine;
import racing.view.View;

public class Application {
    public static void main(String[] args) {
        CarEngine generator = new RandomCarEngine(0, Constant.CAR_MOVE_THRESHOLD);
        View view = new View();
        Controller controller = new Controller(view, generator);
        controller.play();
    }
}
