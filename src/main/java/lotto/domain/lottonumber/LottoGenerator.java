package lotto.domain.lottonumber;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class LottoGenerator {
    static final int[] LOTTO_RULE = {
            Lotto.NUMBER_LOWER_BOUND,
            Lotto.NUMBER_MAX_BOUND,
            Lotto.LOTTO_NUMBER_SIZE
    };

    static public List<Integer> next() throws IllegalArgumentException {

        List<Integer> pickNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_RULE[0], LOTTO_RULE[1], LOTTO_RULE[2]);
        List<Integer> lotto = new ArrayList<>(pickNumbers);
        Collections.sort(lotto);
        return lotto;
    }
}
