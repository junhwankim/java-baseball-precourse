package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("size 메소드로 Set의 size를 확인할 수 있다." +
            "Set은 같은 값은 여러번 삽입해도 한번만 포함된다.")
    void testSize() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("contains 메소드로 값이 존재하지는 확인할 수 있다.")
    void testContains() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("Parameterized Test로 Set 중복코드를 제거할 수 있다.")
    void testContainsUsingParameterizedTest(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"},
            delimiter = ':')
    @DisplayName("Parameterized Test로 CsvSource를 활용할 수 있다.")
    void testContainsUsingCsvSource(String input, String expected) {
        int actualNumber = Integer.parseInt(input);
        boolean expectedFlag = Boolean.parseBoolean(expected);

        assertThat(numbers.contains(actualNumber)).isEqualTo(expectedFlag);
    }
}
