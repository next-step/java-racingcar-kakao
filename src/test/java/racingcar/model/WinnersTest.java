package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinnersTest {

    @DisplayName("우승자가 존재하지 않으면 예외 처리 한다.")
    @Test
    void create_FailWhenEmpty() {
        // when & then
        assertThatThrownBy(() -> new Winners(List.of()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("우승자는 1명이상 존재해야 합니다.");
    }
}
