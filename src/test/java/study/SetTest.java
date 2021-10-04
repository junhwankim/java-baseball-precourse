package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
