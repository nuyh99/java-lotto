package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.exception.InputException;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int purchased;
    private final List<Lotto> lottos = new ArrayList<>();

    public int getPurchased() {
        return purchased;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    /**
     * 도메인 로직
     */
    public void purchase(String input) {
        purchased = validate(input);
        for (int i = 0; i < purchased / 1000; i++)
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
    }


    private int validate(String input) {
        int purchased = validateNumericValue(input);
        validateUnitOfPurchased(purchased);

        return purchased;
    }

    private int validateNumericValue(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException n) {
            throw new IllegalArgumentException(InputException.NOT_A_NUMBER.getMessage());
        }
    }

    private void validateUnitOfPurchased(int input) {
        if (input % 1000 != 0)
            throw new IllegalArgumentException(InputException.INVALID_PURCHASED.getMessage());
    }
}
