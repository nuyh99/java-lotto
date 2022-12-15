package lotto.domain;

import lotto.exception.InputException;

public class User {
    private int purchased;

    public int getPurchased() {
        return purchased;
    }

    public void purchase(String input) {
        purchased = validate(input);
    }

    private int validate(String input) {
        int purchased = toInteger(input);
        validateUnitOfPurchased(purchased);

        return purchased;
    }

    private int toInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException n) {
            throw new IllegalArgumentException(InputException.NOT_A_NUMBER.getMessage());
        }
    }

    private void validateUnitOfPurchased(int input) {
        if(input%1000!=0)
            throw new IllegalArgumentException(InputException.INVALID_PURCHASED.getMessage());
    }
}
