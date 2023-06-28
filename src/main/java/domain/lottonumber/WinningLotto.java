package domain.lottonumber;

public final class WinningLotto extends Lotto {
    private final int bonus;

    public WinningLotto(String readSentence, String bonus) {
        super(readSentence);
        validateBonus(bonus);
        this.bonus = Integer.parseInt(bonus);
    }

    private void validateBonus(String bonus) {
        if (!isNumeric(bonus)) {
            throw new IllegalArgumentException("보너스 번호는 숫자만 가능합니다");
        }
        if (!isInRange(bonus)) {
            throw new IllegalArgumentException("유효하지 않은 보너스 번호");
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
}
