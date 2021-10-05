package baseball.domain;

import java.util.HashSet;
import java.util.Set;

public class Game {
    boolean isFinished;

    public Game() {
    }

    public boolean isFinished() {
        return isFinished;
    }

    public String checkInputNumber(String inputNumber) {
        try {
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }

        return inputNumber;
    }
}
