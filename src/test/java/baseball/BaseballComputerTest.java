package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class BaseballComputerTest {
	@Test
	public void 비교값_상태_테스트() {
		BaseballComputer baseballComputer = new BaseballComputer();
		BaseballState baseballState = baseballComputer.compare("123");
		int sum = baseballState.getBall()+baseballState.getStrike()+baseballState.getNothing();
        assertThat(sum).isEqualTo(3);
	}
}
