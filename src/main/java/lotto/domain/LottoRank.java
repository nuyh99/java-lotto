package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    UNRANKED(-1, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, 2000000000);

    private final int value;
    private final int money;
    private final boolean bonus;

    private LottoRank(int value, int money) {
        this.value = value;
        this.money = money;
        this.bonus = false;
    }

    private LottoRank(int value, boolean bonus, int money) {
        this.value = value;
        this.bonus = bonus;
        this.money = money;
    }

    public static LottoRank findRankByMatches(int count, boolean bonus) {
        return Arrays.stream(LottoRank.values())
                .filter(e -> e.hasSameInfo(count, bonus))
                .findAny()
                .orElse(UNRANKED);
    }

    boolean hasSameInfo(int count, boolean isBonus) {
        return (value == count) && (bonus == isBonus);
    }

    public int getValue() {
        return value;
    }

    public int getMoney() {
        return money;
    }

    public boolean getBonus() {
        return bonus;
    }

}
