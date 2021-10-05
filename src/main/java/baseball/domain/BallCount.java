package baseball.domain;

import baseball.config.message;

public class BallCount {
	private final int strike;
	private final int ball;

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

	private static int checkStrike(Balls userBalls, Balls computerBalls, int index) {
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
		if (isNothing())
			return message.HINT_NOTHING;
		if (isOnlyStrike())
			return String.format(message.HINT_STRIKE, strike);
		if (isOnlyBall())
			return String.format(message.HINT_BALL, ball);

		return String.format(message.HIND_STRIKE_WITH_BALL, strike, ball);
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
