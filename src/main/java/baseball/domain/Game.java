package baseball.domain;

import java.util.HashSet;
import java.util.Set;

public class Game {
    boolean isFinished;

    public boolean isFinished() {
        return isFinished;
    }

    private boolean checkValidInputNumber(String inputNumber) {
        isLengthValid(inputNumber);
        isNotDuplicatedNumber(inputNumber);
        isNotStartsWithZero(inputNumber);

        return true;
    }

    private boolean isNotStartsWithZero(String inputNumber) {
        if (inputNumber.startsWith("0")) {
            throw new IllegalArgumentException("[ERROR] 서로 다른 3개의 숫자를 입력해주세요.");
        }

        return true;
    }

    private boolean isNotDuplicatedNumber(String inputNumber) {
        Set<Character> characterSet = new HashSet<>();

        for (char c: inputNumber.toCharArray()) {
            characterSet.add(c);
        }

        if (characterSet.size() != 3) {
            throw new IllegalArgumentException("[ERROR] 서로 다른 3개의 숫자를 입력해주세요.");
        }

        return true;
    }

    private boolean isLengthValid(String inputNumber) {
        if (inputNumber.length() != 3) {
            throw new IllegalArgumentException("[ERROR] 서로 다른 3개의 숫자를 입력해주세요.");
        }

        return true;
    }

    public String checkInputNumber(String inputNumber) {
        try {
            checkValidInputNumber(inputNumber);
        } catch(IllegalArgumentException e) {
            return e.getMessage();
        }

        return inputNumber;
    }
}
