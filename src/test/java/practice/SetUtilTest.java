package practice;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetUtilTest {
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
    @DisplayName("Set 타입의 변수 사이즈 반환")
    void SET_사이즈() {
        assertThat(SetUtil.size(numbers)).isEqualTo(3);
    }

    @Test
    @DisplayName("Set에 들어있는 값 확인")
    void SET_존재유무() {
    	assertThat(numbers.contains(1)).isTrue();
    	assertThat(numbers.contains(2)).isTrue();
    	assertThat(numbers.contains(3)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("Set에 들어있는 값 확인 @ParameterizedTest와 @ValueSource를 이용하여 중복로직 제거")
    void SET_존재유무_중복제거(int number) {
    	assertThat(numbers.contains(number)).isTrue();
    }
    
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("Set에 들어있는 값 확인 @ParameterizedTest와 @ValueSource를 이용하여 중복로직 제거")
    void SET_존재유무_중복제거2(int number, boolean expected) {
    	assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}
