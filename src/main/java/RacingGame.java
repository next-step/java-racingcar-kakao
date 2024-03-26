import java.util.ArrayList;
import java.util.List;

import model.Car;
import model.RandomGenerator;

import static view.ResultView.printCars;

public class RacingGame {

    private final String carNames;
    private final int tryNo;
    private int gameCount;

    public static List<Car> carList = new ArrayList<>();

    public RacingGame(String carNames, int tryNo) {
        this.carNames = carNames;
        this.tryNo = tryNo;
        makeCar();
        printCars(carList);
    }

    private void makeCar() {
        String[] split = carNames.split(",");
        carList = Car.getCar(split);
    }

    public void race() {
        List<Integer> ranNumList = RandomGenerator.makeRanNumList(tryNo);
        carList = Car.updateCarList(carList, ranNumList);
        gameCount++;
    }

    public List<Car> getCars() {
        return carList;
    }

    public boolean isEnd() {
        return tryNo == gameCount;
    }

    public List<String> getWinners() {
        return Car.getWinnerName(carList);
    }
}
