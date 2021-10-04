package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("split 메소드로 문자열을 분리 할 수 있다.")
    void testSplit() {
        String delimiter = ",";

        assertThat("1,2".split(delimiter)).containsExactly("1", "2");
        assertThat("1,".split(delimiter)).containsExactly("1");
    }

    @Test
    @DisplayName("substring 메소드를 활용해 부분 문자열을 가져올 수 있다.")
    void testSubstring() {
        String example = "(1,2)";

        int beginIndex = 1;
        int endIndex = example.length() - 1;

        String removeParenthesis = example.substring(beginIndex, endIndex);

        assertThat(removeParenthesis).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 메소드를 활용해 특정 위치의 문자를 가져올 수 있다.")
    void testCharAt() {
        String example = "abc";

        assertThat(example.charAt(0)).isEqualTo('a');
        assertThat(example.charAt(1)).isEqualTo('b');
        assertThat(example.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("charAt 메소드를 사용할 때 위치값을 벗어나면 " +
            "StringIndexOutOfBoundsException 예외가 발생한다.")
    void testChatAtThrowsException() {
        String example = "abc";

        assertThatThrownBy(() -> {
            example.charAt(-1);
        }).isInstanceOf(StringIndexOutOfBoundsException.class).
                hasMessageContaining("String index out of range");

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).
                isThrownBy(() -> {
                    example.charAt(4);
                }).withMessageMatching("String index out of range: \\d+");
    }
}
