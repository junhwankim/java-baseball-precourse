package baseball.domain;

import java.util.HashSet;
import java.util.Set;

public class Game {
    boolean isFinished;
    Computer computer;

    public Game() {
        computer = new Computer();
    }

    public boolean isFinished() {
        return isFinished;
    }

    public String checkInputNumber(String inputNumber) {
        try {
            Balls userBalls = Balls.create(inputNumber);
            Balls computerBalls = Balls.create(computer.getNumbers());
            BallCount ballCount = BallCount.create(userBalls, computerBalls);

            checkGameEnd(ballCount);
            return ballCount.toString();
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    private void checkGameEnd(BallCount ballCount) {
        if (ballCount.getStrike() == 3) {
            isFinished = true;
        }
    }
}
