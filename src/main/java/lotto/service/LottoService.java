package lotto.service;

import lotto.domain.Answer;
import lotto.domain.Prize;
import lotto.domain.User;

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

    public void readAnswer(String input) {
        answer.readAnswerNumber(input);
    }

    public void readBonus(String input) {
        answer.readBonusNumber(input);
    }

    public List<Prize> getResult() {
        return user.getLottos().stream()
                .map(o -> Prize.getPrize(
                        o.countMatches(answer.getLotto()),
                        o.getNumbers().contains(answer.getBonus())))
                .collect(Collectors.toList());
    }

}
