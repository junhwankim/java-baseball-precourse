package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
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

	@ParameterizedTest
	@ValueSource(strings = {"12", "34", "5678"})
	void testNotCorrectLengthThrowException(String input) {
		assertThatIllegalArgumentException().isThrownBy(() -> Balls.create(input));
	}

	@ParameterizedTest
	@ValueSource(strings = {"012", "054", "082"})
	void testStartZeroInputThrowException(String input) {
		assertThatIllegalArgumentException().isThrownBy(() -> Balls.create(input));
	}

	@ParameterizedTest
	@ValueSource(strings = {"122", "445", "977"})
	void testDuplicateNumberThrowException(String input) {
		assertThatIllegalArgumentException().isThrownBy(() -> Balls.create(input));
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
}