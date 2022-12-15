package lotto.domain;

import java.util.Arrays;

public enum Prize {
    FIRST(6, false, "2,000,000,000"),
    SECOND(5, true, "30,000,000"),
    THIRD(5, false, "1,500,000"),
    FOURTH(4, false, "50,000"),
    FIFTH(3, false, "5,000"),
    NOTHING(0, false, "0"),;

    private final int countMatches;
    private final boolean bonus;
    private final String prizeMoney;

    Prize(int countMatches, boolean bonus, String prizeMoney) {
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

    public String getPrizeMoney() {
        return this.prizeMoney;
    }
}
