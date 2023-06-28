package lotto.domain;

import lotto.domain.lottonumber.Lotto;
import lotto.domain.lottonumber.LottoGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Computer {
    private static final int LOTTO_PRICE = 1000;

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
