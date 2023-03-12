package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    public static class User {
        private int money;
        private ArrayList<Integer>[] userLotto;

        public User () {
        }

        private void setMoney() throws IllegalArgumentException {
            this.money = Integer.parseInt(Console.readLine());
            if (money % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 금액은 1,000원 단위여야 합니다.");
            }
        }

        private void setLotto(int money){
            userLotto = new ArrayList[money/1000];
            System.out.println(money/1000+"개를 구매했습니다.");
            for(int i=0;i<(money/1000);i++){
                List <Integer> numbers = Randoms.pickUniqueNumbersInRange(1,45,6);
                userLotto[i]=new ArrayList<Integer>(numbers);
                System.out.println(numbers);
            }
        }
    }
    public static void main(String[] args) {
        User user = new User();
        user.setMoney();
        user.setLotto(user.money);
    }
}
