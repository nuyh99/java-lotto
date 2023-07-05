package lotto.domain.lottonumber;

import lotto.domain.LottoRank;

import java.util.List;

public final class WinningLotto extends Lotto {
    private final int bonus;

    public WinningLotto(String readSentence, String bonus) {
        super(readSentence);
        validateBonus(bonus);
        this.bonus = Integer.parseInt(bonus);
    }

    private void validateBonus(String bonus) {
        isNumeric(bonus);
        isInRange(bonus);
        isDuplicate(bonus);
    }

    private void isNumeric(String bonus) {
        try {
            Integer.parseInt(bonus);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 보너스 번호는 숫자만 가능합니다");
            throw new IllegalArgumentException();
        }
    }

    private void isInRange(String bonus) {
        int number = Integer.parseInt(bonus);

        if (NUMBER_LOWER_BOUND > number || number > NUMBER_MAX_BOUND) {
            System.out.println("[ERROR] 유효하지 않은 보너스 번호");
            throw new IllegalArgumentException();
        }
    }

    private void isDuplicate(String bonus) {

        if (getLottoNumbers().contains(Integer.parseInt(bonus))) {
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
