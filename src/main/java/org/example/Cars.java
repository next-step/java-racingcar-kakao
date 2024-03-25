package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> carList = new ArrayList<>();

    public Cars(String inputString) {
        String[] carNames = inputString.split(",");
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
    }

    public int getCarSize() {
        return carList.size();
    }
}
