package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class InputValidatorTest {
    private InputValidator inputValidator;

    @BeforeEach
    void setUp() {
        inputValidator = new InputValidator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"12", "34", "5678"})
    void testNotCorrectLengthThrowException(String input) {
        assertThatIllegalArgumentException().
                isThrownBy(() -> inputValidator.validate(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"012", "054", "082"})
    void testStartZeroInputThrowException(String input) {
        assertThatIllegalArgumentException().
                isThrownBy(() -> inputValidator.validate(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"122", "445", "977"})
    void testDuplicateNumberThrowException(String input) {
        assertThatIllegalArgumentException().
                isThrownBy(() -> inputValidator.validate(input));
    }
}