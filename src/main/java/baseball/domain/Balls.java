package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Balls {
    private final List<Character> ballNumbers;

    private Balls(List<Character> numbers) {
        validateLength(numbers);
        validateNotStartZero(numbers);
        validateNonDuplicate(numbers);

        ballNumbers = numbers;
    }

    public static Balls create(String numbers) {
        List<Character> ballNumbers = new ArrayList<>();

        for (char c : numbers.toCharArray())
            ballNumbers.add(c);

        return new Balls(ballNumbers);
    }

    public Character get(int index) {
        return ballNumbers.get(index);
    }

    public boolean contains(Character digit) {
        return ballNumbers.contains(digit);
    }

    public int size() {
        return ballNumbers.size();
    }

    private void validateLength(List<Character> numbers) {
        if (numbers.size() != 3)
            throw new IllegalArgumentException("[ERROR] 서로 다른 3개의 숫자를 입력해주세요.");
    }

    private void validateNotStartZero(List<Character> numbers) {
        if (numbers.get(0) == '0')
            throw new IllegalArgumentException("[ERROR] 서로 다른 3개의 숫자를 입력해주세요.");
    }

    private void validateNonDuplicate(List<Character> numbers) {
        Set<Character> nonDuplicateNumbers = new HashSet<>(numbers);
        if (nonDuplicateNumbers.size() != 3)
            throw new IllegalArgumentException("[ERROR] 서로 다른 3개의 숫자를 입력해주세요.");
    }
}
