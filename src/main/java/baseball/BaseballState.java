package baseball;

public class BaseballState {
	private final String NOTHING_MSG = "낫싱";
	private final String BALL_MSG = "볼";
	private final String STRIKE_MSG = "스트라이크";
	
	private int strike;
	private int ball;
	private int nothing;
	
	public BaseballState() {
	}

	public void increaseStrike() {
		++this.strike;
	}

	public void increaseBall() {
		++this.ball;
	}
	
	public void increaseNothing() {
		++this.nothing;
	}
	
	public int getStrike() {
		return strike;
	}

	public int getBall() {
		return ball;
	}
	
	public int getNothing() {
		return nothing;
	}

	@Override
	public String toString() {
		if(nothing == 3) {
			return NOTHING_MSG;
		}
		if(strike == 0 && ball > 0) {
			return this.ball + BALL_MSG;
		}
		if(ball == 0 && strike > 0) {
			return this.strike + STRIKE_MSG;
		}
		return this.ball + BALL_MSG + " " + this.strike + STRIKE_MSG;
	}
}
