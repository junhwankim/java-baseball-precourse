package baseball.domain;

public class Game {
	public static final int BALLS_COUNT = 3;

	private boolean isFinished;
	private final Computer computer;

	public Game(Computer computer) {
		this.computer = computer;
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
		if (ballCount.getStrike() == BALLS_COUNT) {
			isFinished = true;
		}
	}
}
