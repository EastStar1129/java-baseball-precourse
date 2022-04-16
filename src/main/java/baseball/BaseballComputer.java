package baseball;

import java.util.LinkedHashSet;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseballComputer {
	private final int NUMBER_LENGTH = 3;
	private final int MIN_NUMBER = 1;
	private final int MAX_NUMBER = 9;
	
	private BaseballNumberList computerNumberList;
	
	public BaseballComputer(){
		validateSetting();
		Set<Character> computerNumberSet = makeComputerNumberSet();
		
		this.computerNumberList = new BaseballNumberList(computerNumberSet);
	}
	
	public BaseballState compare(String input) {
		BaseballNumberList inputList = new BaseballNumberList(input);
		BaseballState baseballState = new BaseballState();
		
		for(int i=0;i<computerNumberList.getNumberList().size();i++) {
			setState(inputList.getNumberList().get(i), i, baseballState);
		}
		return baseballState;
	}
	
	private void setState(Character inputNumber, int i, BaseballState baseballState){
		if(this.computerNumberList.getNumberList().get(i) == inputNumber) {
			baseballState.increaseStrike();
			return ;
		}
		if(this.computerNumberList.getNumberList().contains(inputNumber)) {
			baseballState.increaseBall();
			return ;
		}
		baseballState.increaseNothing();
	}
	
	private Set<Character> makeComputerNumberSet(){
		Set<Character> computerNumberSet = new LinkedHashSet<Character>();
		while(computerNumberSet.size() < NUMBER_LENGTH) {
			char pickNumber = charToint(pickNumberInRange());
			computerNumberSet.add(pickNumber);
		}
		return computerNumberSet;
	}
	
	private int pickNumberInRange(){
		return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
	}
	
	private char charToint(int pickNumber) {
		return Character.forDigit(pickNumber, 10);
	}
	
	@SuppressWarnings("unused")
	private void validateSetting() {
		if(MAX_NUMBER < MIN_NUMBER) {
			throw new IllegalArgumentException("BaseballComputer max, min setting error");
		}
		
		if(NUMBER_LENGTH > MAX_NUMBER - MIN_NUMBER + 1) {
            throw new IllegalArgumentException("BaseballComputer length, max, min setting error");
		}
	}
	
	
}

