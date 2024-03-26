package calulator;

import org.junit.jupiter.api.Test;

import caculator.StringCalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {
    @Test
    void isSplitAndSum_ShouldReturnZeroWithNull() {
        assertThat(StringCalculator.splitAndSum(null)).isEqualTo(0);
    }

    @Test
    void isSplitAndSum_ShouldReturnZeroWithBlack() {
        assertThat(StringCalculator.splitAndSum("")).isEqualTo(0);
    }

    @Test
    void isSplitAndSum_ShouldCalculateOneDigit() {
        assertThat(StringCalculator.splitAndSum("1")).isEqualTo(1);
    }

    @Test
    void isSplitAndSum_ShouldThrowRuntimeExceptionMinus() {
        int num = -1;

        RuntimeException runtimeException =
            assertThrows(RuntimeException.class, () -> StringCalculator.splitAndSum(num+""));
        assertThat(runtimeException.getMessage())
            .isEqualTo("Illegal leading minus sign on unsigned string %d.", num);
    }
    @Test
    void isSplitAndSum_ShouldCalculateByComma() {
        assertThat(StringCalculator.splitAndSum("1,2")).isEqualTo(3);
    }
    @Test
    void isSplitAndSum_ShouldCalculateByCommaAndSemicolon() {
        assertThat(StringCalculator.splitAndSum("1,2;3")).isEqualTo(6);
    }

    @Test
    void isSplitAndSum_ShouldCalculateByCommaAndSemicolonAndCustomSeparator() {
        assertThat(StringCalculator.splitAndSum("//ㄱ\n1ㄱ3ㄱ5;4,1")).isEqualTo(14);
    }
}