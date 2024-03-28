package racing.generator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TrueNumberGeneratorTest {
    @Test
    void trueNumber() {
        NumberGenerator numberGenerator = new TrueNumberGenerator();
        assertThat(numberGenerator.generate()).isEqualTo(9);
    }
}
