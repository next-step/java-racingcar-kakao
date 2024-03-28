package model;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static model.Car.START_SCORE;
import static model.Car.updateCarScore;

public class Race {
    List<Car> carList = new ArrayList<>();

    public Race(List<Car> carList) {
        this.carList = carList;
    }

    public List<Car> getWinner() {
        int maxScore = getMaxScore();

        return this.carList
            .stream()
            .filter(car -> isMaxScoreCar(car, maxScore))
            .collect(toList());
    }

    public boolean isMaxScoreCar(Car car, int maxScore) {
        return car.getScore() == maxScore;
    }

    private int getMaxScore() {
        return this.carList
            .stream()
            .map(Car::getScore)
            .max(Integer::compareTo)
            .orElse(START_SCORE);
    }

    public static void updateCarByNum(List<Car> initCarList, List<Integer> randomNumList) {
        for (int i=0; i<initCarList.size(); i++) {
            updateCarScore(initCarList.get(i), randomNumList.get(i));
        }
    }

}
