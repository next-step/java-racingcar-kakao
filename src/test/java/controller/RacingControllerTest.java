package controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.CarInputView;
import view.CarOutputView;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RacingControllerTest {
    private RacingController racingController;

    @BeforeEach
    void setUp() {
        racingController = new RacingController(
                new CarInputView(),
                new CarOutputView()
        );
    }

    @Test
    @DisplayName("자동차 이름은 5자 이하만 가능하다")
    void validateCarNameTest() {
        String carName = "longlonglong";
        assertThrows(IllegalArgumentException.class,
                () -> racingController.extractCarNames(carName));
    }

}
