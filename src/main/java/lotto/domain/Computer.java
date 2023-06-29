package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Computer {
    private static final int LOTTO_PRICE = 1000;

    private void validate(String price) {

        validateNumber(price);
        validateValidPrice(price);
        
    }

    private void validateNumber(String price) {
        try {
            Integer.parseInt(price);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자만 입력 가능합니다");
            throw new IllegalArgumentException();
        }
    }

    private void validateValidPrice(String price) {

        if (Integer.parseInt(price) % LOTTO_PRICE != 0) {
            System.out.println("[ERROR] 1000원 단위로 입력해야합니다.");
            throw new IllegalArgumentException();
        }
    }

    public List<List<Integer>> buyLottoByPrice(String price) {
        validate(price);
        int amount = Integer.parseInt(price) / LOTTO_PRICE;


        return Stream.generate(LottoGenerator::get)
                .limit(amount)
                .collect(Collectors.toList());
    }
}
