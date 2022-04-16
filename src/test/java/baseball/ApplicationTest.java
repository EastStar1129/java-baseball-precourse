package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;

class ApplicationTest extends NsTest {
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 게임시작_에러() {
    	assertSimpleTest(() ->
	    	assertThatThrownBy(() -> {
	            System.setIn(strToByteArrayInputStream("1234"));
	            Application.gamestart(new BaseballComputer());
	    	}).isInstanceOf(IllegalArgumentException.class)
		);
    }

    @Test
    void 게임오버_테스트1() {
        System.setIn(strToByteArrayInputStream("1"));
        assertThat(Application.gameover()).isInstanceOf(BaseballComputer.class);
    }

    @Test
    void 게임오버_테스트2() {
        System.setIn(strToByteArrayInputStream("2"));
        assertThat(Application.gameover()).isEqualTo(null);
    }
    
    @Test
    void 게임오버_테스트3() {
    	assertSimpleTest(() ->
	    	assertThatThrownBy(() -> {
	            System.setIn(strToByteArrayInputStream("3"));
	            Application.gameover();
	    	}).isInstanceOf(IllegalArgumentException.class)
		);
    }
    
    private ByteArrayInputStream strToByteArrayInputStream(String str) {
        final byte[] buf = str.getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    	return new ByteArrayInputStream(buf);
    }
    
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
