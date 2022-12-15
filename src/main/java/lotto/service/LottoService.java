package lotto.service;

import lotto.domain.Answer;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoService {
    private final Answer answer;
    private final User user;

    public LottoService(Answer answer, User user) {
        this.answer = answer;
        this.user = user;
    }

    public void purchase(String input) {
        user.purchase(input);
    }

    public List<List<Integer>> getPurchased() {
        return user.getLottos().stream()
                .map(Lotto::getNumbers)
                .collect(Collectors.toList());
    }

    public void readAnswer(String input) {
        answer.readAnswerNumber(input);
    }

    public void readBonus(String input) {
        answer.readBonusNumber(input);
    }

    public List<Integer> getResult() {
        List<Integer> result = new ArrayList<>();

        for (Prize prize : Prize.values()) {
            result.add((int) getPrizes().stream()
                    .filter(o -> o.equals(prize))
                    .count());
        }

        return result.subList(0,5);
    }

    public double getEarnedRate() {
        double sum = getPrizes().stream()
                .mapToInt(Prize::getPrizeMoney)
                .sum();

        return sum / user.getPurchased()*100;
    }

    private List<Prize> getPrizes() {
        return user.getLottos().stream()
                .map(o -> Prize.getPrize(
                        o.countMatches(answer.getLotto()),
                        o.getNumbers().contains(answer.getBonus())))
                .filter(o->!o.equals(Prize.NOTHING))
                .collect(Collectors.toList());
    }
}
