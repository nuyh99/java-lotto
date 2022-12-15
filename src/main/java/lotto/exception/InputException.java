package lotto.exception;

public enum InputException {
    NOT_A_NUMBER("숫자를 입력해야 합니다."),
    INVALID_PURCHASED("1000원 단위의 금액을 입력해야 합니다."),
    NEGATIVE_NUMBER("금액은 0원보다 작을 수 없습니다."),;

    private final String prefix="[ERROR] ";
    private final String message;

    InputException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return prefix+message;
    }
}
