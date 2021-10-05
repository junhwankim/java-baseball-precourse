package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BallCountTest {
	private BallCount ballCount;

	private BallCount makeTestBallCount(String input1, String input2) {
		Balls testBall1 = Balls.create(input1);
		Balls testBall2 = Balls.create(input2);

		return BallCount.create(testBall1, testBall2);
	}

	@BeforeEach
	void setUp() {
		ballCount = makeTestBallCount("567", "578");
	}

	@Test
	void testCreate() {
		Balls testBalls1 = Balls.create("123");
		Balls testBalls2 = Balls.create("456");

		assertThat(BallCount.create(testBalls1, testBalls2)).isNotNull();
		assertThat(BallCount.create(testBalls1, testBalls2)).isInstanceOf(BallCount.class);
	}

	@Test
	void getStrike() {
		assertThat(ballCount.getStrike()).isEqualTo(1);
	}

	@Test
	void getBall() {
		assertThat(ballCount.getBall()).isEqualTo(1);
	}

	@ParameterizedTest
	@CsvSource(value = {"123:145:1스트라이크", "567:568:2스트라이크", "456:456:3스트라이크"}, delimiter = ':')
	void testToStringStrike(String input1, String input2, String expected) {
		BallCount ballCount = makeTestBallCount(input1, input2);

		assertThat(ballCount.toString()).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"123:451:1볼", "567:785:2볼", "456:645:3볼"}, delimiter = ':')
	void testToStringBall(String input1, String input2, String expected) {
		BallCount ballCount = makeTestBallCount(input1, input2);

		assertThat(ballCount.toString()).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"123:142:1스트라이크 1볼", "567:765:1스트라이크 2볼"}, delimiter = ':')
	void testToStringStrikeWithBall(String input1, String input2,
		String expected) {
		BallCount ballCount = makeTestBallCount(input1, input2);

		assertThat(ballCount.toString()).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"123:456:낫싱", "567:432:낫싱", "345:789:낫싱"}, delimiter = ':')
	void testToStringNothing(String input1, String input2,
		String expected) {
		BallCount ballCount = makeTestBallCount(input1, input2);

		assertThat(ballCount.toString()).isEqualTo(expected);
	}
}