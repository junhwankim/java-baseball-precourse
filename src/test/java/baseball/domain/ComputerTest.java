package baseball.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest {
	private static String numbers;

	@BeforeAll
	static void beforeAll() {
		Computer computer = new Computer();
		numbers = computer.getNumbers();
	}

	@Test
	@DisplayName("생성한 숫자는 3자리이다.")
	void testDigitLengthIsThree() {
		assertThat(numbers.length()).isEqualTo(3);
	}

	@Test
	@DisplayName("서로 다른 숫자여야 한다.")
	void testDigitNotHaveDuplicates() {
		assertThat(numbers.toCharArray()).doesNotHaveDuplicates();
	}

	@Test
	@DisplayName("숫자로된 문자만 포함해야한다.")
	void testDigitStartsWithGreaterThanOne() {
		assertThat(numbers).containsOnlyDigits();
	}

	@Test
	@DisplayName("0이 포함되어 있으면 안된다.")
	void testDigitNotStartsWithZero() {
		assertThat(numbers).doesNotHaveToString("0");
	}
}