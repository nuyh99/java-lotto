package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1-45 사이의 숫자가 아닐 때 예외가 발생한다.")
    @Test
    void createLottoByOutOfRange() {
        assertThatThrownBy(() -> new Lotto(List.of(49, 2, 3, 4, 5, 5)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스번호가 1-45 사이의 숫자가 아닐 때 예외가 발생한다.")
    @Test
    void createBonusNumberByOutOfRange() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> lotto.setBonusNumber("invalid string"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR]");
    }

    @DisplayName("보너스번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createBonusNumberByDuplicatedNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> lotto.setBonusNumber("6"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR]");
    }

    @DisplayName("로또 순위를 올바르게 리턴하는지 확인한다.")
    @Test
    void returnRank() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        ArrayList<Integer> testlist = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 40, 41, 42));
        RankType result = lotto.checkLottoRank(testlist);
        assertEquals(RankType.RANK_5, result);
    }

}
