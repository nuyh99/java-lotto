package lotto;

import lotto.domain.Computer;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.lottonumber.WinningLotto;
import lotto.views.BuyLottoView;
import lotto.views.LottoResultView;
import lotto.views.WinningLottoView;

import java.util.List;

public final class Controller {
    public static final int PRICE_OF_LOTTO = 1000;
    private static List<List<Integer>> lotto;
    private static WinningLotto winningLotto;

    public void startLottoGame() {
        try {
            buyLotto();
            getWinningLotto();
            getLottoResult();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return;
        }
    }

    private void buyLotto() {
        BuyLottoView buyLottoView = new BuyLottoView();

        lotto = new Computer().buyLottoByPrice(buyLottoView.readPrice());
        buyLottoView.getViewPurchasedLotto(lotto);
        
    }

    private void getWinningLotto() {
        WinningLottoView winningLottoView = new WinningLottoView();
        winningLotto = new WinningLotto(winningLottoView.readWinningLottoNumbers(), winningLottoView.readBonusNumber());
    }

    private void getLottoResult() {
        LottoResult lottoResult = new LottoResult(lotto, winningLotto);
        LottoResultView lottoResultView = new LottoResultView();

        for (LottoRank rank : LottoRank.values()) {
            int amount = lottoResult.getNumberOfRanks(rank);
            if (rank == LottoRank.UNRANKED) continue;

            printResult(lottoResultView, rank, amount);
        }
        printAverageProfit(lottoResult, lottoResultView);
    }

    private void printAverageProfit(LottoResult lottoResult, LottoResultView lottoResultView) {
        double average = lottoResult.getAverageProfit(lotto.size() * PRICE_OF_LOTTO);
        System.out.println(lottoResultView.getViewAverageProfit(average));
    }

    private void printResult(LottoResultView lottoResultView, LottoRank rank, int amount) {
        System.out.println(lottoResultView
                .getViewRankInfo(rank.getValue(), rank.getMoney(), amount, rank == LottoRank.SECOND));

    }
}
