package lotto.domain;

import lotto.exception.InputException;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Answer {
    private Lotto lotto;

    public void readAnswerNumber(String input) {
        lotto = new Lotto(validate(input));
    }

    private List<Integer> validate(String input) {
        validateInputLength(input);
        List<Integer> result = validateNumeric(new StringTokenizer(input));
        validateDuplicated(result);

        return result;
    }

    private void validateInputLength(String input) {
        StringTokenizer st = new StringTokenizer(input);

        if(st.countTokens()!=6)
            throw new IllegalArgumentException(InputException.INVALID_NUMBER_LENGTH.getMessage());
    }

    private List<Integer> validateNumeric(StringTokenizer input) {
        try {
            List<Integer> result = new ArrayList<>();
            while (input.hasMoreTokens())
                result.add(Integer.parseInt(input.nextToken()));

            return result;
        } catch (NumberFormatException n) {
            throw new IllegalArgumentException(InputException.NOT_A_NUMBER.getMessage());
        }
    }

    private void validateDuplicated(List<Integer> input) {
        if(input.size() != input.stream().distinct().count())
            throw new IllegalArgumentException(InputException.DUPLICATED.getMessage());
    }
}
