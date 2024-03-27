package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RandomNumberGeneratorTest {
    @Test
    @DisplayName("0부터 9까지 랜덤한 숫자를 생성한다")
    void generateRandomNumberTest() {
        int randomNumber = RandomNumberGenerator.generate();

        assertThat(randomNumber).isBetween(0, 9);
    }
}
