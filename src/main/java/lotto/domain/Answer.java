package lotto.domain;

import lotto.exception.InputException;

import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Answer {
    private Lotto lotto;

    public void readAnswerNumber(String input) {
        lotto = new Lotto(validate(input));
    }

    private List<Integer> validate(String input) {
        validateInputLength(input);

        return validateNumericValue(new StringTokenizer(input));
    }

    private void validateInputLength(String input) {
        StringTokenizer st = new StringTokenizer(input);

        if(st.countTokens()!=6)
            throw new IllegalArgumentException(InputException.INVALID_NUMBER_LENGTH.getMessage());
    }

    private List<Integer> validateNumericValue(StringTokenizer input) {
        try {
            return IntStream.range(0, 6)
                    .map(o -> Integer.parseInt(input.nextToken()))
                    .boxed()
                    .collect(Collectors.toList());
        } catch (NumberFormatException n) {
            throw new IllegalArgumentException(InputException.NOT_A_NUMBER.getMessage());
        }
    }
}
