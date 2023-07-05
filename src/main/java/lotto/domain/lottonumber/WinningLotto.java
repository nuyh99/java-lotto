package lotto.domain.lottonumber;

import lotto.domain.LottoRank;

import java.util.List;

public final class WinningLotto extends Lotto {
    private final int bonus;

    public WinningLotto(List<Integer> lottoNumbers, int bonus) {
        super(lottoNumbers);
        validateBonus(bonus);
        this.bonus = bonus;
    }

    private void validateBonus(int bonus) {
        isInRange(bonus);
        isDuplicate(bonus);
    }


    private void isInRange(int bonus) {
        if (NUMBER_LOWER_BOUND > bonus || bonus > NUMBER_MAX_BOUND) {
            System.out.println("[ERROR] 유효하지 않은 보너스 번호");
            throw new IllegalArgumentException();
        }
    }

    private void isDuplicate(int bonus) {

        if (getLottoNumbers().contains(bonus)) {
            System.out.println("[ERROR] 보너스 번호와 로또 번호는 중복되선 안됩니다.");
            throw new IllegalArgumentException();
        }
        ;
    }

    public LottoRank checkRank(List<Integer> lottoNumbers) {
        int matches = (int) lottoNumbers
                .stream()
                .filter(getLottoNumbers()::contains)
                .count();

        boolean isBonus = (matches == LottoRank.SECOND.getValue()
                && lottoNumbers.contains(bonus));

        return LottoRank.findRankByMatches(matches, isBonus);
    }
}
