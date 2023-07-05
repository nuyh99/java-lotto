package lotto;

import lotto.domain.Computer;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.lottonumber.Lotto;
import lotto.domain.lottonumber.WinningLotto;
import lotto.views.InputReadView;
import lotto.views.LottoBuyView;
import lotto.views.LottoResultView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class Controller {
    public static final int PRICE_OF_LOTTO = 1000;

    private static final Computer computer = new Computer();
    private static final InputReadView inputReadView = new InputReadView();
    private static final LottoBuyView lottoBuyView = new LottoBuyView();
    private static final LottoResult lottoResult = new LottoResult();

    public void startLottoGame() {
        try {
            List<Lotto> purchasedLotto = buyLotto(inputReadView.readPrice());
            WinningLotto winningLotto = getWinningLotto();
            getLottoResult(purchasedLotto, winningLotto);
        } catch (IllegalArgumentException e) {
        }

    }

    private List<Lotto> buyLotto(String price) throws IllegalArgumentException {


        List<Lotto> lotto = computer.buyLottoByPrice(Integer.parseInt(price));
        lottoBuyView.printViewPurchasedLotto(convertLotto(lotto));
        return lotto;
    }

    private List<List<Integer>> convertLotto(List<Lotto> lotto) {
        return lotto.stream()
                .map(Lotto::getLottoNumbers)
                .collect(Collectors.toList());
    }

    private WinningLotto getWinningLotto() {
        List<Integer> lottoNumbers = splitNumberGroup(inputReadView.readLottoNumbers());
        int bonus = Integer.parseInt(inputReadView.readBonusNumber());

        return new WinningLotto(lottoNumbers, bonus);
    }

    private List<Integer> splitNumberGroup(String readLottoNumbers) {
        String[] splitNumber = readLottoNumbers.split(",");
        return Arrays.stream(splitNumber)
                .mapToInt(Integer::valueOf)
                .boxed()
                .collect(Collectors.toList());
    }

    private void getLottoResult(List<Lotto> purchasedLotto, WinningLotto winningLotto) {

        List<LottoRank> lottoRanks = lottoResult.getLottoRanks(purchasedLotto, winningLotto);

        LottoResultView lottoResultView = new LottoResultView();

        printRanks(lottoRanks, lottoResultView);
        printAverageProfit(lottoRanks, lottoResultView);
    }

    private void printRanks(List<LottoRank> lottoRanks, LottoResultView lottoResultView) {
        for (LottoRank rank : LottoRank.values()) {
            if (rank == LottoRank.UNRANKED) {
                continue;
            }
            int rankAmount = lottoResult.getNumberOfRanks(lottoRanks, rank);
            lottoResultView.printViewLottoRank(rank.getValue(), rank.getMoney(), rankAmount, rank == LottoRank.SECOND);
        }
    }

    private void printAverageProfit(List<LottoRank> lottoRanks, LottoResultView lottoResultView) {
        int totalPrice = lottoRanks.size() * PRICE_OF_LOTTO;
        double average = lottoResult.getAverageProfit(lottoRanks, totalPrice);
        lottoResultView.printViewAverageProfit(average);
    }
}
