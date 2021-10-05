package baseball.domain;

public class BallCount {
    private int strike;
    private int ball;

    private BallCount(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public static BallCount create(Balls userBalls, Balls computerBalls) {
        int strike = getStrikeCount(userBalls, computerBalls);
        int ball = getBallCount(userBalls, computerBalls);

        return new BallCount(strike, ball);
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    private static int getStrikeCount(Balls userBalls, Balls computerBalls) {
        int strike = 0;
        for (int i = 0; i < userBalls.size(); i++) {
            strike += checkStrike(userBalls, computerBalls, i);
        }
        return strike;
    }

    private static int checkStrike(Balls userBalls, Balls computerBalls,
                                   int index) {
        if (userBalls.get(index) == computerBalls.get(index))
            return 1;

        return 0;
    }

    private static int getBallCount(Balls userBalls, Balls computerBalls) {
        int ball = 0;
        for (int i = 0; i < userBalls.size(); i++) {
            ball += checkBall(userBalls, computerBalls, i);
        }
        return ball;
    }

    private static int checkBall(Balls userBalls, Balls computerBalls, int index) {
        if (userBalls.get(index) == computerBalls.get(index))
            return 0;

        if (computerBalls.contains(userBalls.get(index)))
            return 1;

        return 0;
    }

    @Override
    public String toString() {
        if (isNothing()) return "낫싱";
        if (isOnlyStrike()) return String.format("%d스트라이크", strike);
        if (isOnlyBall()) return String.format("%d볼", ball);

        return String.format("%d스트라이크 %d볼", strike, ball);
    }

    private boolean isOnlyBall() {
        return strike == 0 && ball > 0;
    }

    private boolean isOnlyStrike() {
        return strike > 0 && ball == 0;
    }

    private boolean isNothing() {
        return strike == 0 && ball == 0;
    }
}
