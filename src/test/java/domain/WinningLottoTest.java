package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class WinningLottoTest {
    @DisplayName("보너스 번호가 1 ~ 45가 아니면 예외가 발생한다.")
    @Test
    void createBonusByOutOfRange() {
        Assertions.assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5), 49))
                .isInstanceOf(IllegalArgumentException.class);

    }

}