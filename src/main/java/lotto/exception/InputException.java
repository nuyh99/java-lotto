package lotto.exception;

public enum InputException {
    NOT_A_NUMBER("숫자를 입력해야 합니다."),
    INVALID_PURCHASED("1000원 단위의 금액을 입력해야 합니다."),
    NEGATIVE_NUMBER("금액은 0원보다 작을 수 없습니다."),
    INVALID_NUMBER_LENGTH("로또는 6개의 숫자여야 합니다."),
    DUPLICATED("중복된 숫자가 존재합니다."),
    INVALID_NUMBER_RANGE("1~45의 숫자를 입력해야 합니다."),;

    private final String prefix="[ERROR] ";
    private final String message;

    InputException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return prefix+message;
    }
}
