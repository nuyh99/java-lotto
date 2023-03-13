package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {

    private static double printGameResult(ArrayList<Integer> list) {
        System.out.println("당첨 통계");
        System.out.println("---");

        System.out.println("3개 일치 (5,000원) - " + list.get(0) + "개");
        System.out.println("4개 일치 (50,000원) - " + list.get(1) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + list.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + list.get(3) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + list.get(4) + "개");

        return list.get(0) * 5000.0 + list.get(1) * 50000.0 + list.get(2) * 1500000.0
            + list.get(3) * 30000000.0 + list.get(4) * 2000000000.0;
    }

    private static class User {

        private int money;
        private ArrayList<Integer>[] userLotto;

        public User() {
        }

        private void setMoney() throws IllegalArgumentException {
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

        private void setLotto(int money) {
            userLotto = new ArrayList[money / 1000];
            System.out.println(money / 1000 + "개를 구매했습니다.");
            for (int i = 0; i < (money / 1000); i++) {
                List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
                userLotto[i] = new ArrayList<Integer>(numbers);
                System.out.println(numbers);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> luckylist = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
        User user = new User();

        try {
            user.setMoney();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        user.setLotto(user.money);
        String str = Console.readLine();
        Stream<Integer> lucky_num =
            Pattern.compile(",").splitAsStream(str)
                .map(s -> Integer.parseInt(s));

        Lotto lotto = new Lotto(lucky_num.collect(Collectors.toList()));

        lotto.setBonusNumber();

        for (int i = 0; i < user.money / 1000; i++) {
            int index = lotto.checkLottoRank(user.userLotto[i]);
            if (index > 0) {
                luckylist.set(5 - index, luckylist.get(5 - index) + 1);
            }
        }

        double income = printGameResult(luckylist);
        System.out.println("총 수익률은 " + (income / (double) user.money) * 100.0 + "%입니다.");
    }
}
