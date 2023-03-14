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

    private static void printGameResult(ArrayList<Integer> list) {
        System.out.println("당첨 통계");
        System.out.println("---");

        System.out.println("3개 일치 (5,000원) - " + list.get(0) + "개");
        System.out.println("4개 일치 (50,000원) - " + list.get(1) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + list.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + list.get(3) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + list.get(4) + "개");

    }

    public static void main(String[] args) {
        ArrayList<Integer> luckylist = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
        User user = new User();
        
        /*입력으로 문자열이 들어올 경우 throw된 예외 처리*/
        try {
            user.setMoney();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        /*생성된 유저의 로또 출력*/
        user.setLotto(user.money);
        for (int i = 0; i < (user.money / 1000); i++) {
            System.out.println(user.userLotto[i]);
        }
        
        /*당첨번호를 입력받아 ','를 기준으로 분리후 당첨번호 넣어 로또 객체 생성*/
        String str1 = Console.readLine();
        Stream<Integer> lucky_num =
            Pattern.compile(",").splitAsStream(str1)
                .map(s -> Integer.parseInt(s));

        Lotto lotto = new Lotto(lucky_num.collect(Collectors.toList()));
        
        /*보너스번호를 입력받아 User객체의 BOUUS_NUM에 저장*/
        String str2 = Console.readLine();
        lotto.setBonusNumber(str2);

        /*당첨 결과 계산 및 출력*/
        double income = 0.0;
        for (int i = 0; i < user.money / 1000; i++) {
            RankType rank = lotto.checkLottoRank(user.userLotto[i]);
            if (rank.getRank() != 0) {
                luckylist.set(5 - rank.getRank(), luckylist.get(5 - rank.getRank()) + 1);
                income += rank.getCost();
            }
        }

        printGameResult(luckylist);
        System.out.println("총 수익률은 " + (income / (double) user.money) * 100.0 + "%입니다.");
    }
}
