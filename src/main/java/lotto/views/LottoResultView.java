package lotto.views;

public final class LottoResultView {
    public LottoResultView() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public String getViewRankInfo(int matches, int money, int amount, boolean bonus) {
        if (bonus) return String.format("%d개 일치, 보너스 볼 일치 (%,d원) - %d개", matches, money, amount);
        return String.format("%d개 일치 (%,d원) - %d개", matches, money, amount);
    }

    public String getViewAverageProfit(double average) {
        return String.format("총 수익률은 %.1f%% 입니다.", average * 100);
    }
}
