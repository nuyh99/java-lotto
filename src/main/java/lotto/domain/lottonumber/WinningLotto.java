package lotto.domain.lottonumber;

import lotto.domain.LottoRank;

import java.util.List;

import static lotto.domain.LottoGenerator.NUMBER_LOWER_BOUND;
import static lotto.domain.LottoGenerator.NUMBER_MAX_BOUND;

public final class WinningLotto extends Lotto {
    private final int bonus;

    public WinningLotto(String readSentence, String bonus) {
        super(readSentence);
        validateBonus(bonus);
        this.bonus = Integer.parseInt(bonus);
    }

    private void validateBonus(String bonus) {
        if (!isNumeric(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자만 가능합니다");
        }
        if (!isInRange(bonus)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 보너스 번호");
        }
        if (isOverpopulation(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호와 로또 번호는 중복되선 안됩니다.");
        }
    }

    private boolean isInRange(String bonus) {
        int number = Integer.parseInt(bonus);
        return (NUMBER_LOWER_BOUND <= number && number <= NUMBER_MAX_BOUND);
    }

    private boolean isNumeric(String bonus) {
        try {
            Integer.parseInt(bonus);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private boolean isOverpopulation(String bonus) {
        return getNumbers().contains(Integer.parseInt(bonus));
    }

    public LottoRank checkRank(List<Integer> lottoNumbers) {
        int matches = (int) lottoNumbers
                .stream()
                .filter(getNumbers()::contains)
                .count();

        boolean isBonus = lottoNumbers.contains(bonus);

        return LottoRank.findRankByMatches(matches, isBonus);
    }
}
