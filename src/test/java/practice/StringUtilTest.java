package practice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringUtilTest {


    @Test
    @DisplayName("문자열을 특정 문자열로 나누었을 때 나누어진 배열 반환 contains이용")
    void 문자열_자르기_테스트1() {
        assertThat(StringUtil.split("1,2",",")).contains("1","2");
    }

    @Test
    @DisplayName("문자열을 특정 문자열로 나누었을 때 나누어진 배열 반환 containsExactly이용")
    void 문자열_자르기_테스트2() {
        assertThat(StringUtil.split("1,2",",")).containsExactly("1","2");
    }

    @Test
    @DisplayName("문자열에서 괄호가 양옆에 있는 경우 괄호가 제거된 문자열 반환")
    void 괄호_제거() {
        assertThat(StringUtil.removeBracket("(1,2)")).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열에서 괄호가 양옆에 없는경우 문자열 자체 반환")
    void 괄호_제거_예외() {
        assertThat(StringUtil.removeBracket("1,2)")).isEqualTo("1,2)");
    }
    
    @Test
    @DisplayName("문자열에서 특정 위치를 가져오는 성공로직")
    void 문자열_특정위치_가져오기1() {
        assertThat(StringUtil.charAt("abc",0)).isEqualTo('a');
    }
    
    @Test
    @DisplayName("문자열에서 특정 위치를 가져오는 성공로직")
    void 문자열_특정위치_가져오기2() {
        assertThat(StringUtil.charAt("abc",1)).isEqualTo('b');
    }
    
    @Test
    @DisplayName("문자열에서 특정 위치를 가져오는 성공로직")
    void 문자열_특정위치_가져오기3() {
        assertThat(StringUtil.charAt("abc",2)).isEqualTo('c');
    }
    
    @Test
    @DisplayName("문자열에서 특정위치 값을 가져올때 문자열의 길이보다 찾으려는 인덱스가 클 경우 예외 발생")
    void 문자열_특정위치_가져오기_예외() {
    	assertThatThrownBy(() -> {
            StringUtil.charAt("abc",4);
    	}).isInstanceOf(StringIndexOutOfBoundsException.class)
    	.hasMessageContaining("Index: 4, Size: 3");
    }
}
