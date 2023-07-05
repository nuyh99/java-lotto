package lotto.views;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public final class InputReadView {

    public String readPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String readNumber = Console.readLine();

        validateNumber(readNumber);
        return readNumber;
    }

    public String readLottoNumbers() {
        System.out.println("로또 번호를 입력해주세요.");
        String readSentence = Console.readLine();

        validateLottoFormat(readSentence);

        return readSentence;
    }

    public String readBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해주세요.\n");

        String bonusNumber = Console.readLine();

        validateNumber(bonusNumber);
        return bonusNumber;
    }

    private void validateNumber(String price) throws IllegalArgumentException {
        try {
            Integer.parseInt(price);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자만 입력 가능합니다");
            throw new IllegalArgumentException();
        }
    }

    private void validateLottoFormat(String readSentence) {
        if (Pattern.matches("[^0-9,]+", readSentence)) {
            System.out.println("[ERROR] 올바르지 않은 형식입니다");
            throw new IllegalArgumentException();
        }
    }
}
