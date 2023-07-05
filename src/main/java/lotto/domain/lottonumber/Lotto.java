package lotto.domain.lottonumber;

import java.util.HashSet;
import java.util.List;


public class Lotto {
    static final int NUMBER_LOWER_BOUND = 1;
    static final int NUMBER_MAX_BOUND = 45;
    static final int LOTTO_NUMBER_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    protected void validate(List<Integer> testNumbers) {

        if (testNumbers.size() != LOTTO_NUMBER_SIZE) {
            System.out.println("[ERROR] 로또 번호는 6개이어야 합니다.");
            throw new IllegalArgumentException();
        }
        validateNumberRange(testNumbers);
        validateDuplicateNumber(testNumbers);
    }

    private void validateNumberRange(List<Integer> numbers) {
        final int size = (int) numbers.stream()
                .filter(e -> NUMBER_LOWER_BOUND <= e && e <= NUMBER_MAX_BOUND)
                .count();

        if (size != LOTTO_NUMBER_SIZE) {
            System.out.println("[ERROR] 로또 번호는 1 ~ 45 사이여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        int numberAmount = (int) new HashSet<>(numbers).size();

        if (numberAmount != LOTTO_NUMBER_SIZE) {
            System.out.println("[ERROR] 로또 번호는 중복되어선 안됩니다.");
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }
}
