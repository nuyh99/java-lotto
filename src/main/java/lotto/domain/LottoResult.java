package lotto.domain;

import lotto.domain.lottonumber.WinningLotto;

import java.util.ArrayList;
import java.util.List;

public final class LottoResult {
    private static final List<LottoRank> lottoResults = new ArrayList<>();

    public LottoResult(List<List<Integer>> lotto, WinningLotto winningLotto) {
        for (List<Integer> currentLotto : lotto) {
            lottoResults.add(winningLotto.checkRank(currentLotto));
        }
    }

    public int getNumberOfRanks(LottoRank rank) {
        return (int) lottoResults.stream()
                .filter(e -> e == rank)
                .count();
    }

    public double getAverageProfit(int totalPrice) {
        double sum = 0;
        for (LottoRank lottoRank : lottoResults) {
            sum += lottoRank.getMoney();
        }
        return sum / totalPrice;
    }


}
