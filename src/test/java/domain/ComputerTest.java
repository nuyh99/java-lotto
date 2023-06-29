package domain;

import lotto.domain.Computer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ComputerTest {

    @DisplayName("가격이 1000단위가 아니면 얘외가 발생한다.")
    @Test
    void buyLottoByInvalidPrice() {

        assertThatThrownBy(() -> new Computer().buyLottoByPrice("1040"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}