package baseball;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BaseballNumberListTest {

    @ParameterizedTest
    @ValueSource(strings = {"1234", "12", "1ab", "'@c", "112"})
    @DisplayName("Baseball Model객체의 값 테스트, 중복없는 숫자 3자리")
    void SET_존재유무_중복제거(String str) {
		 assertThatThrownBy(() -> new BaseballNumberList(str))
        .isInstanceOf(IllegalArgumentException.class);
    }
}
