package lotto.domain;

import lotto.exception.InputException;

import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Answer {
    private Lotto lotto;
    private int bonus;

    /**
     * 도메인 로직
     */
    public void readAnswerNumber(String input) {
        lotto = new Lotto(validateAnswer(input));
    }

    public void readBonusNumber(String input) {
        int bonus = validateBonus(input);

        if(lotto.getNumbers().contains(bonus))
            throw new IllegalArgumentException(InputException.DUPLICATED.getMessage());

        this.bonus = bonus;
    }

    private List<Integer> validateAnswer(String input) {
        validateInputLength(input);
        List<Integer> result = validateNumericValue(new StringTokenizer(input, ","));
        result.forEach(this::validateNumberRange);

        return result;
    }

    private int validateBonus(String input) {
        try {
            int result = Integer.parseInt(input);
            validateNumberRange(result);

            return result;
        } catch (NumberFormatException n) {
            throw new IllegalArgumentException(InputException.NOT_A_NUMBER.getMessage());
        }
    }

    private void validateInputLength(String input) {
        StringTokenizer st = new StringTokenizer(input, ",");

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

    private void validateNumberRange(int number) {
        if(number<1 || 45<number)
            throw new IllegalArgumentException(InputException.INVALID_NUMBER_RANGE.getMessage());
    }
}
