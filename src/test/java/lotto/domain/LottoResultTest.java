package lotto.domain;

import lotto.domain.lottonumber.Lotto;
import lotto.domain.lottonumber.WinningLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoResultTest {

    @DisplayName("RANK FIRST 반환되어야 한다.")
    @Test
    void getLottoFIRSTRanks() {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 45);
        List<Lotto> lotto = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(2, 1, 5, 6, 4, 3)),
                new Lotto(List.of(6, 5, 4, 3, 2, 1))
        );
        List<LottoRank> ranks = new LottoResult().getLottoRanks(lotto, winningLotto);
        for (LottoRank rank : ranks) {
            Assertions.assertThat(rank).isEqualTo(LottoRank.FIRST);
        }
    }

    @DisplayName("RANK SECOND 반환되어야 한다.")
    @Test
    void getLottoSECONDRanks() {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 45);
        List<Lotto> lotto = List.of(
                new Lotto(List.of(45, 2, 3, 4, 5, 6)),
                new Lotto(List.of(2, 1, 45, 6, 4, 3)),
                new Lotto(List.of(6, 5, 4, 3, 45, 1))
        );
        List<LottoRank> ranks = new LottoResult().getLottoRanks(lotto, winningLotto);
        for (LottoRank rank : ranks) {
            Assertions.assertThat(rank).isEqualTo(LottoRank.SECOND);
        }
    }

    @DisplayName("RANK THIRD 반환되어야 한다.")
    @Test
    void getLottoTHIRDRanks() {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 45);
        List<Lotto> lotto = List.of(
                new Lotto(List.of(30, 2, 3, 4, 5, 6)),
                new Lotto(List.of(2, 1, 42, 6, 4, 3)),
                new Lotto(List.of(6, 5, 4, 3, 44, 1))
        );
        List<LottoRank> ranks = new LottoResult().getLottoRanks(lotto, winningLotto);
        for (LottoRank rank : ranks) {
            Assertions.assertThat(rank).isEqualTo(LottoRank.THIRD);
        }
    }

    @DisplayName("RANK FOURTH 반환되어야 한다.")
    @Test
    void getLottoFOURTHRanks() {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 45);
        List<Lotto> lotto = List.of(
                new Lotto(List.of(30, 21, 3, 4, 5, 6)),
                new Lotto(List.of(2, 1, 42, 6, 41, 3)),
                new Lotto(List.of(6, 5, 4, 33, 44, 1))
        );
        List<LottoRank> ranks = new LottoResult().getLottoRanks(lotto, winningLotto);
        for (LottoRank rank : ranks) {
            Assertions.assertThat(rank).isEqualTo(LottoRank.FOURTH);
        }
    }

    @DisplayName("RANK FIFTH 반환되어야 한다.")
    @Test
    void getLottoFIFTHRanks() {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 45);
        List<Lotto> lotto = List.of(
                new Lotto(List.of(30, 21, 31, 4, 5, 6)),
                new Lotto(List.of(24, 1, 42, 6, 45, 3)),
                new Lotto(List.of(6, 5, 4, 33, 44, 45))
        );
        List<LottoRank> ranks = new LottoResult().getLottoRanks(lotto, winningLotto);
        for (LottoRank rank : ranks) {
            Assertions.assertThat(rank).isEqualTo(LottoRank.FIFTH);
        }
    }

    @DisplayName("RANK FIFTH 반환되어야 한다.")
    @Test
    void getLottoUNRANKEDRanks() {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 45);
        List<Lotto> lotto = List.of(
                new Lotto(List.of(30, 21, 31, 4, 5, 20)),
                new Lotto(List.of(24, 10, 42, 7, 45, 8)),
                new Lotto(List.of(6, 15, 41, 33, 44, 45))
        );
        List<LottoRank> ranks = new LottoResult().getLottoRanks(lotto, winningLotto);
        for (LottoRank rank : ranks) {
            Assertions.assertThat(rank).isEqualTo(LottoRank.UNRANKED);
        }
    }
}