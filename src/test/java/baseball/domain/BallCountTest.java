package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
	@DisplayName("create method로 인스턴스를 생성 할 수 있다.")
	void testCreate() {
		Balls testBalls1 = Balls.create("123");
		Balls testBalls2 = Balls.create("456");

		assertThat(BallCount.create(testBalls1, testBalls2)).isNotNull();
		assertThat(BallCount.create(testBalls1, testBalls2)).isInstanceOf(BallCount.class);
	}

	@Test
	@DisplayName("스트라이크의 수가 예상대로 반환하는지 확인한다.")
	void getStrike() {
		assertThat(ballCount.getStrike()).isEqualTo(1);
	}

	@Test
	@DisplayName("볼의 수가 예상대로 반환하는지 확인한다.")
	void getBall() {
		assertThat(ballCount.getBall()).isEqualTo(1);
	}

	@ParameterizedTest
	@CsvSource(value = {"123:145:1스트라이크", "567:568:2스트라이크", "456:456:3스트라이크"}, delimiter = ':')
	@DisplayName("여러 입력 값을 전달 했을 때 스트라이크 결과를 확인한다.")
	void testToStringStrike(String input1, String input2, String expected) {
		BallCount ballCount = makeTestBallCount(input1, input2);

		assertThat(ballCount.toString()).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"123:451:1볼", "567:785:2볼", "456:645:3볼"}, delimiter = ':')
	@DisplayName("여러 입력 값을 전달 했을 때 볼 결과를 확인한다.")
	void testToStringBall(String input1, String input2, String expected) {
		BallCount ballCount = makeTestBallCount(input1, input2);

		assertThat(ballCount.toString()).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"123:142:1스트라이크 1볼", "567:765:1스트라이크 2볼"}, delimiter = ':')
	@DisplayName("여러 입력 값을 전달 했을 때 스트라이크와 볼의 결과를 확인한다.")
	void testToStringStrikeWithBall(String input1, String input2,
		String expected) {
		BallCount ballCount = makeTestBallCount(input1, input2);

		assertThat(ballCount.toString()).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"123:456:낫싱", "567:432:낫싱", "345:789:낫싱"}, delimiter = ':')
	@DisplayName("여러 입력 값을 전달 했을 때 낫싱의 결과를 확인한다.")
	void testToStringNothing(String input1, String input2,
		String expected) {
		BallCount ballCount = makeTestBallCount(input1, input2);

		assertThat(ballCount.toString()).isEqualTo(expected);
	}
}