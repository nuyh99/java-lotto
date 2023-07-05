package lotto.domain;

import lotto.domain.lottonumber.Lotto;
import lotto.domain.lottonumber.WinningLotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class LottoResult {

    public List<LottoRank> getLottoRanks(List<Lotto> lotto, WinningLotto winningLotto) {
        List<LottoRank> lottoResults = new ArrayList<>();
        for (Lotto currentLotto : lotto) {
            lottoResults.add(winningLotto.checkRank(currentLotto.getLottoNumbers()));
        }
        return lottoResults;
    }

    public int getNumberOfRanks(List<LottoRank> lottoResults, LottoRank rank) {
        return (int) lottoResults.stream()
                .filter(e -> e == rank)
                .count();
    }

    public double getAverageProfit(List<LottoRank> lottoResults, int totalPrice) {
        double sum = 0;
        for (LottoRank lottoRank : lottoResults) {
            sum += lottoRank.getMoney();
        }
        return sum / totalPrice;
    }


}
