package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;


public final class LottoGenerator {
    public static final int NUMBER_LOWER_BOUND = 1;
    public static final int NUMBER_MAX_BOUND = 45;
    public static final int LOTTO_NUMBER_SIZE = 6;

    static List<Integer> get() {
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange(NUMBER_LOWER_BOUND, NUMBER_MAX_BOUND, LOTTO_NUMBER_SIZE);

        Collections.sort(lotto);
        return lotto;
    }
}
