package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseballComputerTest {
	@Test
    @DisplayName("숫자가 모두 비교되었는지 확인")
	public void 비교값_상태_테스트() {
		BaseballComputer baseballComputer = new BaseballComputer();
		BaseballState baseballState = baseballComputer.compare("123");
		int sum = baseballState.getBall()+baseballState.getStrike()+baseballState.getNothing();
        assertThat(sum).isEqualTo(3);
	}
}
