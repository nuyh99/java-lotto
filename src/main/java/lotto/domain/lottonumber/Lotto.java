package lotto.domain.lottonumber;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.domain.LottoGenerator.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Lotto(String readSentence) {
        List<Integer> numbers = getLottoNumberBySentence(readSentence);
        validate(numbers);
        this.numbers = numbers;

    }

    protected void validate(List<Integer> testNumbers) {
        if (testNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개이어야 합니다.");
        }
        if (!validateNumRange(testNumbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45 사이여야 합니다.");
        }
        if (!validateDuplicateNumber(testNumbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되어선 안됩니다.");
        }
    }

    private boolean validateNumRange(List<Integer> numbers) {
        final int size = (int) numbers.stream()
                .filter(e -> NUMBER_LOWER_BOUND <= e && e <= NUMBER_MAX_BOUND)
                .count();

        return size == LOTTO_NUMBER_SIZE;
    }

    private boolean validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> nonOverlappedNumbers = new HashSet<>(numbers);
        return nonOverlappedNumbers.size() == LOTTO_NUMBER_SIZE;
    }

    private List<Integer> getLottoNumberBySentence(String readSentence) {
        try {
            return splitNumberGroup(readSentence.split(","));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수만 입력 가능합니다");
        }
    }

    private List<Integer> splitNumberGroup(String[] readNumbers) throws NumberFormatException {
        return Arrays.stream(readNumbers)
                .mapToInt(Integer::valueOf)
                .boxed()
                .collect(Collectors.toList());
    }

    final List<Integer> getNumbers() {
        return numbers;
    }
}
