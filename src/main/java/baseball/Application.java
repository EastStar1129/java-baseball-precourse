package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {

	private static final String GAMEOVER_MSG = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\r\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	
    public static void main(String[] args) {
    	gamestart(new BaseballComputer());
    }
    
    public static void gamestart(BaseballComputer bc) {
    	BaseballState output = compareInput(bc);
    	System.out.println(output.toString());
    	if(output.getStrike() == 3) {
    		bc = gameover();
    	}
    	if(bc != null) {
    		gamestart(bc);
    	}
    }
    
    public static BaseballState compareInput(BaseballComputer bc) {
    	System.out.print("숫자를 입력해주세요 : ");
    	String input = Console.readLine();
    	return bc.compare(input);
    }
    
    public static BaseballComputer gameover() {
		System.out.println(GAMEOVER_MSG);
    	String input = Console.readLine();
    	if(input.equals("1")) {
    		return new BaseballComputer();
    	}
    	if(input.equals("2")) {
    		return null;
    	}
    	throw new IllegalArgumentException("applcation restart input error, input awalys 1,2");
    }
}
