package lotto.domain;

import lotto.domain.lottonumber.Lotto;
import lotto.domain.lottonumber.LottoGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Computer {

    static final int LOTTO_PRICE = 1000;

    public List<Lotto> buyLottoByPrice(int price) {

        validateValidPrice(price);
        int amount = price / LOTTO_PRICE;
        return Stream.generate(LottoGenerator::next)
                .limit(amount)
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

    private void validateValidPrice(int price) {

        if (price % LOTTO_PRICE != 0) {
            System.out.println("[ERROR] 1000원 단위로 입력해야합니다.");
            throw new IllegalArgumentException();
        }
    }
}
