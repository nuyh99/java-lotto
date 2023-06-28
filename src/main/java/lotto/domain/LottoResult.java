package lotto.domain;

import lotto.domain.lottonumber.Lotto;
import lotto.domain.lottonumber.WinningLotto;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public final class LottoResult {
    private static final String HALF_UP_AT_SECOND = "0.#";
    private static final List<LottoRank> lottoResults = new ArrayList<>();

    LottoResult(List<Lotto> lotto, WinningLotto winningLotto) {
        for (Lotto currentLotto : lotto) {
            lottoResults.add(winningLotto.checkRank(currentLotto));
        }
    }

    public int getNumberOfRanks(LottoRank rank) {
        return (int) lottoResults.stream()
                .filter(e -> e == rank)
                .count();
    }

    public String getAverageProfit() {
        double sum = 0;
        for (LottoRank lottoRank : lottoResults) {
            sum += lottoRank.getMoney();
        }
        DecimalFormat decimalFormat = new DecimalFormat(HALF_UP_AT_SECOND);
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        return decimalFormat.format(sum);
    }


}
