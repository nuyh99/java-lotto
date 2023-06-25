package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoGenerator {
    final public Lotto get(int minNum, int maxNum, int count) {
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange(minNum, maxNum, count);
        return new Lotto(lotto);
    }
}
