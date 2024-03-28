package model;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


public class CarTest {

    @Test
    void isGetCar_ShouldReturnSplitCarList(){
        String carString="pobi,crong,honux";
        String[] split = carString.split(",");
        List<Car> carList = Car.getCar(split);

        List<Car> expectedCarList = new ArrayList<>();
        expectedCarList.add(new Car("pobi", Car.START_SCORE));
        expectedCarList.add(new Car("crong", Car.START_SCORE));
        expectedCarList.add(new Car("honux", Car.START_SCORE));

        assertThat(carList).isEqualTo(expectedCarList);
    }

    @Test
    void isGetCar_ShouldThrowIllegalArgumentExceptionWithOverFive(){
        String carStr="longNamehaha";

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                new Car(carStr, 0);
            }).withMessage("차량 이름은 5자를 넘어서는 안됩니다.");
    }

    @Test
    void isMakeRanNumList_ShouldReturnRandomNumListByCarSize() {
        String carString="pobi,crong,honux";
        String[] split = carString.split(",");
        int expectedSize = split.length;

        List<Integer> randomNumList = RandomGenerator.makeRanNumList(split.length);
        assertThat(randomNumList.size()).isEqualTo(expectedSize);
    }
}
