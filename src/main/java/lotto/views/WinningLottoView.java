package lotto.views;

import camp.nextstep.edu.missionutils.Console;

public final class WinningLottoView {
    public String readWinningLottoNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.\n");
        return Console.readLine();
    }

    public String readBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해주세요.\n");
        return Console.readLine();
    }
}
