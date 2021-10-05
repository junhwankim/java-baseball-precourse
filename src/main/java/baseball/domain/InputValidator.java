package baseball.domain;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    public void validate(String inputNumber) {
        validateLength(inputNumber);
        validateNonDuplicateNumber(inputNumber);
        validateNotStartZero(inputNumber);
    }

    private void validateNotStartZero(String inputNumber) {
        if (inputNumber.startsWith("0"))
            throw new IllegalArgumentException("[ERROR] 서로 다른 3개의 숫자를 입력해주세요.");
    }

    private void validateNonDuplicateNumber(String inputNumber) {
        Set<Character> characterSet = new HashSet<>();

        for (char c : inputNumber.toCharArray())
            characterSet.add(c);

        if (characterSet.size() != 3)
            throw new IllegalArgumentException("[ERROR] 서로 다른 3개의 숫자를 입력해주세요.");
    }

    private void validateLength(String inputNumber) {
        if (inputNumber.length() != 3)
            throw new IllegalArgumentException("[ERROR] 서로 다른 3개의 숫자를 입력해주세요.");
    }
}
