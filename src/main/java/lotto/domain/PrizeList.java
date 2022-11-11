package lotto.domain;

public class PrizeList {
    private int first;
    private int second;
    private int third;
    private int fourth;
    private int fifth;

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public int getThird() {
        return third;
    }

    public int getFourth() {
        return fourth;
    }

    public int getFifth() {
        return fifth;
    }

    public void addCount(Prize prize) {
        if (prize == Prize.FIRST)
            first++;
        if (prize == Prize.SECOND)
            second++;
        if (prize == Prize.THIRD)
            third++;
        if (prize == Prize.FOURTH)
            fourth++;
        if (prize == Prize.FIFTH)
            fifth++;
    }

    public long getYield() {
        long result = 0;

        result += (long) first * Prize.FIRST.getPrize();
        result += (long) second * Prize.SECOND.getPrize();
        result += (long) third * Prize.THIRD.getPrize();
        result += (long) fourth * Prize.FOURTH.getPrize();
        result += (long) fifth * Prize.FIFTH.getPrize();

        return result;
    }
}
