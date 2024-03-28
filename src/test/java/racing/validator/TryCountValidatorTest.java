package racing.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TryCountValidatorTest {
    TryCountValidator validator;
    @BeforeEach
    void setUp() {
        validator = new TryCountValidator();
    }

    @Test
    void tryCountSuccessTest() {
        Assertions.assertThat(validator.validate("123")).isTrue();
    }

    @Test
    void tryCountFailTest() {
        Assertions.assertThat(validator.validate("1a3")).isFalse();
    }
}
