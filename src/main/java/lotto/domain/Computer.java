package lotto.domain;

import lotto.domain.lottonumber.Lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Computer {
    private static final int LOTTO_PRICE = 1000;

    public List<Lotto> buyLottoByPrice(String price) {

        validate(price);
        int amount = Integer.parseInt(price) / LOTTO_PRICE;

        return getLotto(amount);
    }

    private List<Lotto> getLotto(int amount) {
        return Stream.generate(LottoGenerator::next)
                .limit(amount)
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

    private void validate(String price) throws IllegalArgumentException {

        validateNumber(price);
        validateValidPrice(price);
    }

    private void validateNumber(String price) throws IllegalArgumentException {
        try {
            Integer.parseInt(price);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자만 입력 가능합니다");
            throw new IllegalArgumentException();
        }
    }

    private void validateValidPrice(String price) throws IllegalArgumentException {

        if (Integer.parseInt(price) % LOTTO_PRICE != 0) {
            System.out.println("[ERROR] 1000원 단위로 입력해야합니다.");
            throw new IllegalArgumentException();
        }
    }
}
