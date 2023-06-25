package domain;

import java.util.List;

public class WinningLotto extends Lotto {
    private final int bonus;

    public WinningLotto(List<Integer> numbers, int bonus) {
        super(numbers);
        validateBonus(bonus);
        this.bonus = bonus;
    }

    private void validateBonus(int bonus) {
        if (NUMBER_LOWER_BOUND <= bonus && bonus <= NUMBER_MAX_BOUND) {
            throw new IllegalArgumentException("유효하지 않은 보너스 번호");
        }
    }
}
