package controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarControllerTest {
    private CarController carController;

    @BeforeEach
    void setUp() {
        carController = new CarController();
    }

    @Test
    @DisplayName("자동차 이름은 5자 이하만 가능하다")
    void validateCarNameTest() {
        String carName = "longlonglong";
        assertThrows(IllegalArgumentException.class,
                () -> carController.validateCarName(carName));
    }

}
