package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private Integer BONUS_NUM;
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개 이여야 합니다.");
        }
        if(numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException("[ERROR] 중복된 번호가 존재합니다.");
        }
        if(numbers.size() != numbers.stream().filter(n->(n>=1&&n<=45)).count()){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
    public void setBonusNumber() {
        String str = Console.readLine();
        try {
            this.BONUS_NUM= Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println("[Error] 보너스 번호는 문자열이 될 수 없습니다.");
        }
        if (BONUS_NUM<=1 && BONUS_NUM>=45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (numbers.contains(BONUS_NUM)) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호가 존재합니다.");
        }
    }

     public int checkLottoRank(ArrayList<Integer> user_numbers){
        long duplicate_num = user_numbers.stream().filter(n->numbers.contains(n)).count();
        if(duplicate_num==3){
            return 5;
        }
        if(duplicate_num==4){
            return 4;
        }
        if(duplicate_num==5){
            if(user_numbers.stream().filter(n->numbers.contains(duplicate_num)).count()>=1){
                return 2;
            }
            return 3;
        }
        if(duplicate_num==6){
            return 1;
        }
        return 0;
     }

}
