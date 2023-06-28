package lotto.domain.lottonumber;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

import static lotto.domain.lottonumber.Lotto.*;

public final class LottoGenerator {
    final public Lotto get() {
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange(NUMBER_LOWER_BOUND, NUMBER_MAX_BOUND, LOTTO_NUMBER_SIZE);

        Collections.sort(lotto);
        return new Lotto(lotto);
    }
}
