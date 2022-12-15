package lotto.view;

import java.util.List;

public class OutputView {
    public void printLottos(List<List<Integer>> lottos){
        System.out.println("\n"+lottos.size()+"개를 구매했습니다.");
        lottos.forEach(o-> System.out.println(o.toString()));
    }

    public void printResult(List<Integer> prizes, double earnedRate) {
        System.out.println("\n당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - "+prizes.get(0)+"개");
        System.out.println("4개 일치 (50,000원) - "+prizes.get(1)+"개");
        System.out.println("5개 일치 (1,500,000원) - "+prizes.get(2)+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+prizes.get(3)+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+prizes.get(4)+"개");
        System.out.println("총 수익률은 "+ String.format("%.1f", earnedRate) +"%입니다.");
    }
}
