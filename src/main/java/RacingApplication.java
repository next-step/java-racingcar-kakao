import controller.RacingController;
import service.RacingService;
import view.CarInputView;
import view.CarOutputView;

public class RacingApplication {
    public static void main(String[] args) {
        CarInputView carInputView = new CarInputView();
        CarOutputView carOutputView = new CarOutputView();
        RacingService racingService = new RacingService();
        RacingController racingController =
                new RacingController(carInputView, carOutputView, racingService);

        racingController.start();
    }
}
