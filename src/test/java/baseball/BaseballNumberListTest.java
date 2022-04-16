package baseball;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class BaseballNumberListTest {

	@Test
	public void 자리수체크_4자리(){
		 assertThatThrownBy(() -> new BaseballNumberList("1234"))
         .isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void 자리수체크_2자리(){
		 assertThatThrownBy(() -> new BaseballNumberList("12"))
         .isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void 숫자체크_헥사코드(){
		 assertThatThrownBy(() -> new BaseballNumberList("1ab"))
         .isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void 숫자체크_특수문자(){
		 assertThatThrownBy(() -> new BaseballNumberList("'@c"))
         .isInstanceOf(IllegalArgumentException.class);
	}
	
	@Test
	public void 중복값체크(){
		 assertThatThrownBy(() -> new BaseballNumberList("112"))
         .isInstanceOf(IllegalArgumentException.class);
	}
}
