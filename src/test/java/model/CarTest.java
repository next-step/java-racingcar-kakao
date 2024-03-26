package model;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


public class CarTest {

    @Test
    void isGetWinner_ShouldReturnMaxCountCarList() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("first", 5));
        carList.add(new Car("second", 4));
        carList.add(new Car("third", 5));
        carList.add(new Car("firth", 2));

        List<Car> expectedWinner = new ArrayList<>();;
        expectedWinner.add(new Car("first", 5));
        expectedWinner.add(new Car("third", 5));

        List<Car> winnerList = Car.getWinner(carList);
        assertThat(winnerList).isEqualTo(expectedWinner);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void isUpdateCarScore_ShouldIncreaseScoreGreaterOrEqualWithFour(int num) {
        Car car = new Car("name",0);
        Car expectedMove = new Car("name",1);
        Car afterMove = Car.updateCarScore(car, num);
        assertThat(expectedMove).isEqualTo(afterMove);
    }


    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void isUpdateCarScore_ShouldNotIncreaseScoreLessOrEqualWithThree(int num) {
        Car car = new Car("name",0);
        Car expectedMove = new Car("name",0);
        Car afterMove = Car.updateCarScore(car, num);
        assertThat(expectedMove).isEqualTo(afterMove);
    }

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
                Car.validate(carStr);
            }).withMessage("5자 이상 불가능");
    }

    @Test
    void isMakeRanNumList_ShouldReturnRandomNumListByCarSize() {
        String carString="pobi,crong,honux";
        String[] split = carString.split(",");
        int expectedSize = split.length;

        List<Integer> randomNumList = RandomGenerator.makeRanNumList(split.length);
        assertThat(randomNumList.size()).isEqualTo(expectedSize);
    }

    @Test
    void isUpdateCarList_ShouldReturnCarListWithUpdatedScore() {
        List<Integer> randomNumList = new ArrayList<>();
        randomNumList.add(4);
        randomNumList.add(2);
        randomNumList.add(7);

        List<Car> initCarList = new ArrayList<>();
        initCarList.add(new Car("pobi", 0));
        initCarList.add(new Car("crong", 0));
        initCarList.add(new Car("honux", 0));

        List<Car> updateCarList = Car.updateCarList(initCarList, randomNumList);

        List<Car> expectedCarList = new ArrayList<>();
        expectedCarList.add(new Car("pobi", 1));
        expectedCarList.add(new Car("crong", 0));
        expectedCarList.add(new Car("honux", 1));

        assertThat(updateCarList).isEqualTo(expectedCarList);
    }
}
