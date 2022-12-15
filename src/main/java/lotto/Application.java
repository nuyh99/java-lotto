package lotto;

import lotto.controller.LottoController;
import lotto.domain.Answer;
import lotto.domain.User;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = init();

        try {
            lottoController.purchase();
            lottoController.setAnswer();
            lottoController.result();
        } catch (IllegalArgumentException i) {
            System.out.println(i.getMessage());
        }
    }

    private static LottoController init() {
        return new LottoController(
                new LottoService(new Answer(), new User()),
                new InputView(),
                new OutputView());
    }
}
