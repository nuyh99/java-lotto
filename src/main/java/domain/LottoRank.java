package domain;

public enum LottoRank {
    FIRST(6, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

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
