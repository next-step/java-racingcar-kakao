package racing;

import racing.controller.Controller;
import racing.domain.NumberGenerator;
import racing.infra.RandomNumberGenerator;
import racing.view.View;

public class Application {
    public static void main(String[] args) {
        NumberGenerator generator = new RandomNumberGenerator(0);
        View view = new View();
        Controller controller = new Controller(view, generator);
        controller.play();
    }
}
