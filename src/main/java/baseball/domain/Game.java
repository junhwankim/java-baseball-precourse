package baseball.domain;

import java.util.HashSet;
import java.util.Set;

public class Game {
    boolean isFinished;
    InputValidator inputValidator;

    public Game() {
        this.inputValidator = new InputValidator();
    }

    public boolean isFinished() {
        return isFinished;
    }

    public String checkInputNumber(String inputNumber) {
        try {
            inputValidator.validate(inputNumber);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }

        return inputNumber;
    }
}
