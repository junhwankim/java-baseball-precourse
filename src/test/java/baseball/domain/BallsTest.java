package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class BallsTest {
	private Balls balls;

	@BeforeEach
	void setUp() {
		balls = Balls.create("567");
	}

	@Test
	void testGet() {
		assertThat(balls.get(0)).isEqualTo('5');
	}

	@Test
	void testContains() {
		assertThat(balls.contains('7')).isTrue();
	}

	@Test
	void testSize() {
		assertThat(balls.size()).isEqualTo(3);
	}

	@ParameterizedTest
	@ValueSource(strings = {"12", "34", "5678"})
	@DisplayName("길이가 3인 값을 입력하지 않으면 예외를 반환한다.")
	void testNotCorrectLengthThrowException(String input) {
		assertThatIllegalArgumentException().isThrownBy(() -> Balls.create(input));
	}

	@ParameterizedTest
	@ValueSource(strings = {"012", "054", "082"})
	@DisplayName("0으로 시작하는 값을 입력하면 예외를 반환한다.")
	void testStartZeroInputThrowException(String input) {
		assertThatIllegalArgumentException().isThrownBy(() -> Balls.create(input));
	}

	@ParameterizedTest
	@ValueSource(strings = {"122", "445", "977"})
	@DisplayName("서로 중복된 숫자를 입력하는 경우 입력하면 예외를 반환한다.")
	void testDuplicateNumberThrowException(String input) {
		assertThatIllegalArgumentException().isThrownBy(() -> Balls.create(input));
	}

	@ParameterizedTest
	@ValueSource(strings = {"1a2", "4b5", "9c7"})
	@DisplayName("숫자로만 구성되어야 한다. 그렇지 않으면 예외를 반환한다.")
	void testNotAllDigitThrowException(String input) {
		assertThatIllegalArgumentException().isThrownBy(() -> Balls.create(input));
	}
}