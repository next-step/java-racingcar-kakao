package view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarInputViewTest {
    private CarInputView carInputView;

    @BeforeEach
    void setUp() {
        carInputView = new CarInputView();
    }

    @Test
    @DisplayName("자동차 이름은 5자 이하만 가능하다")
    void validateCarNameTest() {
        String carName = "longlonglong";
        assertThrows(IllegalArgumentException.class,
                () -> carInputView.getCarNames(carName));
    }

}
