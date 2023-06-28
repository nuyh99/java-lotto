package domain;

import domain.lottonumber.Lotto;
import domain.lottonumber.LottoGenerator;
import domain.lottonumber.WinningLotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Computer {
    private static final int LOTTO_PRICE = 1000;

    public LottoResult checkLottoRank(List<Lotto> lottos, WinningLotto winningLotto) {
        for (Lotto lotto : lottos) {
        }
    }

    public List<Lotto> buyLottoByPrice(int price) {
        if (price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 입력 금액은 1000 단위만 가능합니다");
        }
        int amount = price / LOTTO_PRICE;

        final LottoGenerator lottoGenerator = new LottoGenerator();

        return Stream.generate(lottoGenerator::get)
                .limit(amount)
                .collect(Collectors.toList());
    }
}
