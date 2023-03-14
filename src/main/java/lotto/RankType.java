package lotto;

public enum RankType {
    RANK_5(5, 5_000),
    RANK_4(4, 50_000),
    RANK_3(3, 1_500_000),
    RANK_2(2, 30_000_000),
    RANK_1(1, 2_000_000_000),
    RANK_NULL(0, 0);

    public final int rank;
    public final double cost;

    RankType(int rank, double cost) {
        this.rank = rank;
        this.cost = cost;
    }

    public int getRank() {
        return rank;
    }

    public double getCost() {
        return cost;
    }
}
