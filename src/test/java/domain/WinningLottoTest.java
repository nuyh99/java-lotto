package domain;

import lotto.domain.LottoRank;
import lotto.domain.lottonumber.WinningLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class WinningLottoTest {
    @DisplayName("보너스 번호가 1 ~ 45가 아니면 예외가 발생한다.")
    @Test
    void createBonusByOutOfRange() {
        assertThatThrownBy(() ->
                new WinningLotto("1,2,3,4,6,7", "49"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 로또 번호에 문자가 존재하면 예외가 발생한다.")
    @Test
    void createWinningLottoByWords() {
        assertThatThrownBy(() ->
                new WinningLotto("1,2,3,a,6,7", "40"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 로또 번호가 6자리가 넘으면 예외가 발생한다.")
    @Test
    void createWinningLottoByOverSize() {
        assertThatThrownBy(() ->
                new WinningLotto("1,2,3,5,6,7,8,9", "40"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 로또 번호가 6자리 미만이면 예외가 발생한다.")
    @Test
    void createWinningLottoByUnderSize() {
        assertThatThrownBy(() ->
                new WinningLotto("1,2,3,7,5", "40"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 로또 입력에 ',' 를 잘못 입력했을 경우")
    @Test
    void createWinningLottoByIncorrectRegex() {
        Assertions.assertThatThrownBy(() ->
                        new WinningLotto("1,2,3.75", "40"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호와 보너스 번호가 중복이면 예외가 발생한다")
    @Test
    void createOverlappedBonusNumber() {
        assertThatThrownBy(() ->
                new WinningLotto("1,2,3,7,5,6", "6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("매칭 결과 Lott Rank FIRST 여야한다.")
    @Test
    void createFirstRankLotto() {
        WinningLotto winningLotto = new WinningLotto("3,2,6,4,1,45", "10");
        List<Integer> lotto = List.of(1, 2, 3, 4, 6, 45);
        assertThat(winningLotto.checkRank(lotto)).isEqualTo(LottoRank.FIRST);
    }

    @DisplayName("매칭 결과 Lott Rank SECOND 여야한다.")
    @Test
    void createSecondRankLotto() {
        WinningLotto winningLotto = new WinningLotto("3,2,6,4,1,42", "45");
        List<Integer> lotto = List.of(1, 2, 3, 4, 6, 45);
        assertThat(winningLotto.checkRank(lotto)).isEqualTo(LottoRank.SECOND);
    }

    @DisplayName("매칭 결과 Lott Rank SECOND 여야한다.")
    @Test
    void createThirdRankLotto() {
        WinningLotto winningLotto = new WinningLotto("3,2,6,4,1,10", "20");
        List<Integer> lotto = List.of(1, 2, 3, 4, 6, 45);
        assertThat(winningLotto.checkRank(lotto)).isEqualTo(LottoRank.THIRD);
    }

    @DisplayName("매칭 결과 Lott Rank FOURTH 여야한다.")
    @Test
    void createFourthRankLotto() {
        WinningLotto winningLotto = new WinningLotto("3,2,32,4,1,10", "20");
        List<Integer> lotto = List.of(1, 2, 3, 4, 6, 20);
        assertThat(winningLotto.checkRank(lotto)).isEqualTo(LottoRank.FOURTH);
    }

    @DisplayName("매칭 결과 Lott Rank FIFTH 여야한다.")
    @Test
    void createFifthRankLotto() {
        WinningLotto winningLotto = new WinningLotto("3,2,6,15,10,43", "20");
        List<Integer> lotto = List.of(1, 2, 3, 4, 6, 44);
        assertThat(winningLotto.checkRank(lotto)).isEqualTo(LottoRank.FIFTH);
    }

    @DisplayName("매칭 결과 Lott Rank FIFTH 여야한다.")
    @Test
    void createUnRankedLotto() {
        WinningLotto winningLotto = new WinningLotto("3,2,6,15,10,43", "20");
        List<Integer> lotto = List.of(10, 20, 2, 40, 32, 44);
        assertThat(winningLotto.checkRank(lotto)).isEqualTo(LottoRank.UNRANKED);
    }
}