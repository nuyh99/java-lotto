package lotto.views;

import java.util.List;
import java.util.stream.Collectors;

public final class LottoBuyView {
    static final InputReadView inputReadView = new InputReadView();

    public void printViewPurchasedLotto(List<List<Integer>> lotto) {
        System.out.println();
        System.out.printf("%d개를 구매했습니다.\n", lotto.size());
        for (List<Integer> currentLotto : lotto) {
            System.out.printf("[%s]\n", getFormattedLottoNumbers(currentLotto));
        }
    }

    private String getFormattedLottoNumbers(List<Integer> currentLotto) {
        List<String> lottoNumbers = currentLotto
                .stream()
                .map(String::valueOf)
                .collect(Collectors.toList());

        return String.join(", ", lottoNumbers);
    }
}
