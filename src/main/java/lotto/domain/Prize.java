package lotto.domain;

import java.util.Arrays;

public enum Prize {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NOTHING(0, false, 0),;

    private final int countMatches;
    private final boolean bonus;
    private final int prizeMoney;

    Prize(int countMatches, boolean bonus, int prizeMoney) {
        this.countMatches = countMatches;
        this.bonus = bonus;
        this.prizeMoney = prizeMoney;
    }

    public static Prize getPrize(int countMatches, boolean bonus) {
        return Arrays.stream(Prize.values())
                .filter(o -> o.countMatches == countMatches && o.bonus == bonus)
                .findFirst()
                .orElse(NOTHING);
    }

    public int getPrizeMoney() {
        return this.prizeMoney;
    }
}
