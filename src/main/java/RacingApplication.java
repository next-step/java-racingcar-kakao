import controller.RacingController;
import service.RacingService;
import util.RandomNumberGenerator;
import view.RacingGameView;

public class RacingApplication {
    public static void main(String[] args) {
        RacingGameView racingGameView = new RacingGameView();
        RacingService racingService = new RacingService();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        RacingController racingController =
                new RacingController(racingGameView, racingService, randomNumberGenerator);

        racingController.start();
    }
}
