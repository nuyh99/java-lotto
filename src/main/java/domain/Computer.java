package domain;

public final class Computer {
    public static final int LOTTO_PRICE = 1000;
    private final int price;

    public Computer(int price) {
        validPrice(price);
        this.price = price;
    }

    private void validPrice(int price) {
        if (price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 입력 금액은 1000 단위만 가능합니다");
        }
    }
}
