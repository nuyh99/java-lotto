package lotto.domain;

import lotto.exception.InputException;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    /**
     * 도메인 로직
     */
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(InputException.INVALID_NUMBER_LENGTH.getMessage());
        }
    }

    // TODO: 추가 기능 구현
}
