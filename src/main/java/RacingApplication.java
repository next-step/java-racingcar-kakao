import controller.RacingController;
import view.View;

public class RacingApplication {
    public static void main(String[] args) {
        View view = new View();
        RacingController racingController =
                new RacingController(view);

        racingController.start();
    }
}
