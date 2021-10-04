package baseball.domain;

import nextstep.utils.Randoms;

import java.util.LinkedHashSet;
import java.util.Set;

public class Computer {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int DIGIT_LENGTH = 3;

    private String numbers;

    public Computer() {
    }

    public String getNumbers() {
        if (this.numbers == null) {
            setNumbers();
        }

        return this.numbers;
    }

    private void setNumbers() {
        Set<Character> digits = generateNonDuplicateDigits();

        this.numbers = characterSetToString(digits);
    }

    private String characterSetToString(Set<Character> digits) {
        Character[] chars = digits.toArray(new Character[0]);
        StringBuilder sb = new StringBuilder();

        for (char c : chars) {
            sb.append(c);
        }

        return sb.toString();
    }

    private Set<Character> generateNonDuplicateDigits() {
        Set<Character> digits = new LinkedHashSet<>();
        int radix = 10;

        do {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            digits.add(Character.forDigit(randomNumber, radix));
        } while (digits.size() < DIGIT_LENGTH);

        return digits;
    }
}
