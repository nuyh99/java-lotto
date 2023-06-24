package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final int NUMBER_MIN_BOUNDARY = 1;
    public static final int NUMBER_MAX_BOUNDARY = 45;
    public static final int LOTTO_NUMBER_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> testNumbers) {
        if (testNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개이어야 합니다.");
        }
        if (!validateNumRange(testNumbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45 사이여야 합니다.");
        }
        if (!checkOverlap(testNumbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되어선 안됩니다.");
        }

    }

    private boolean checkOverlap(List<Integer> numbers) {
        Set<Integer> nonOverlappedNumbers = new HashSet<>(numbers);
        return nonOverlappedNumbers.size() == LOTTO_NUMBER_SIZE;
    }

    private boolean validateNumRange(List<Integer> numbers) {
        final int size = (int) numbers.stream()
                .filter(e -> NUMBER_MIN_BOUNDARY <= e && e <= NUMBER_MAX_BOUNDARY)
                .count();

        return size == LOTTO_NUMBER_SIZE;
    }
}
