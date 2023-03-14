package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class User {
    public int money;
    public ArrayList<Integer>[] userLotto;

    public User() {
    }

    public void setMoney() throws IllegalArgumentException {
        String str = Console.readLine();
        try {
            this.money = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            this.money = -1;
        }

        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1,000원 단위여야 합니다.");
        }
    }

    public void setLotto(int money) {
        userLotto = new ArrayList[money / 1000];
        System.out.println(money / 1000 + "개를 구매했습니다.");
        for (int i = 0; i < (money / 1000); i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            userLotto[i] = new ArrayList<Integer>(numbers);
        }
    }
}