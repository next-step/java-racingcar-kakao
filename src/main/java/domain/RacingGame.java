package domain;

import view.InputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    public Car[] cars;

    public void gameStart(){
        int cnt = 5;
        while (cnt-- > 0) {
            move();
        }
    }

    public RacingGame(String [] carNames) {
        Car[] cars = new Car[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i]);
        }
        this.cars = cars;
    }



    public void move() {
        for (int i = 0; i < cars.length; i++) {
            cars[i].checkForwardMotion(createRandomNumber());
        }
    }

    private int createRandomNumber() {
        //0~9
        return (int) (Math.random() * 9);
    }

    public List<String> selectWinners() {

        int maxPosition = Arrays.stream(cars)
                .mapToInt(car -> car.position)
                .max()
                .orElse(0);
        List<String> namesWithMaxPosition = Arrays.stream(cars)
                .filter(car -> car.position == maxPosition)
                .map(car -> car.name)
                .collect(Collectors.toList());
        return namesWithMaxPosition;
    }

}
