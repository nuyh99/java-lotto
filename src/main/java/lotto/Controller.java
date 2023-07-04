package lotto;

import lotto.domain.Computer;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.lottonumber.WinningLotto;
import lotto.views.LottoBuyView;
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
        }

    }

    private void buyLotto() throws IllegalArgumentException {

        LottoBuyView lottoBuyView = new LottoBuyView();

        lotto = new Computer().buyLottoByPrice(lottoBuyView.readPrice());
        lottoBuyView.printViewPurchasedLotto(lotto);


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
            if (rank == LottoRank.UNRANKED) {
                continue;
            }

            printResult(lottoResultView, rank, amount);
        }
        printAverageProfit(lottoResult, lottoResultView);
    }

    private void printAverageProfit(LottoResult lottoResult, LottoResultView lottoResultView) {
        int totalPrice = lotto.size() * PRICE_OF_LOTTO;
        double average = lottoResult.getAverageProfit(totalPrice);

        lottoResultView.printViewAverageProfit(average);
    }

    private void printResult(LottoResultView lottoResultView, LottoRank rank, int amount) {
        lottoResultView.printViewRankInfo(rank.getValue(), rank.getMoney(), amount, rank == LottoRank.SECOND);

    }
}
