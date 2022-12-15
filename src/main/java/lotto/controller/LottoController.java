package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Collections;
import java.util.List;

public class LottoController {
    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void purchase() {
        String input = inputView.readPurchased();
        lottoService.purchase(input);
        outputView.printLottos(lottoService.getPurchased());
    }

    public void setAnswer() {
        lottoService.readAnswer(inputView.readAnswerNumber());
        lottoService.readBonus(inputView.readBonus());
    }

    public void result() {
        List<Integer> result = lottoService.getResult();
        Collections.reverse(result);
        double earnedRate = lottoService.getEarnedRate();

        outputView.printResult(result, earnedRate);
    }
}
