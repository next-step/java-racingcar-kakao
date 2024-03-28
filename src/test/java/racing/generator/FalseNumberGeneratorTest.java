package racing.generator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FalseNumberGeneratorTest {
    @Test
    void falseNumber() {
        NumberGenerator numberGenerator = new FalseNumberGenerator();
        assertThat(numberGenerator.generate()).isEqualTo(0);
    }
}
