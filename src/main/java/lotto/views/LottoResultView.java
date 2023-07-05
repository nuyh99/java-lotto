package lotto.views;

public final class LottoResultView {
    public LottoResultView() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public void printViewLottoRank(int matches, int money, int amount, boolean bonus) {
        if (bonus) {
            System.out.printf("%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n", matches, money, amount);
            return;
        }
        System.out.printf("%d개 일치 (%,d원) - %d개\n", matches, money, amount);
    }

    public void printViewAverageProfit(double average) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", average * 100);
    }
}
