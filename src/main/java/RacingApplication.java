import controller.RacingController;
import view.CarInputView;
import view.CarOutputView;

public class RacingApplication {
    public static void main(String[] args) {
        CarInputView carInputView = new CarInputView();
        CarOutputView carOutputView = new CarOutputView();
        RacingController racingController =
                new RacingController(carInputView, carOutputView);

        racingController.start();
    }
}
