package racing.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarNameValidatorTest {
    CarNameValidator validator;
    @BeforeEach
    void setUp() {
        validator = new CarNameValidator();
    }

    @Test
    void carNameValidateSuccess() {
        String carNames = "abc,def,ghi";

        assertThat(validator.validate(carNames));
    }

    @Test
    void carNameValidateFail() {
        String carNames = "abcdef,advegdd";

        assertThat(validator.validate(carNames)).isFalse();
    }
}
