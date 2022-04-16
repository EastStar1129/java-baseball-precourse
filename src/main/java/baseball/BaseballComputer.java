package baseball;

import java.util.HashSet;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseballComputer {
	private final int NUMBER_LENGTH = 3;
	private final int MIN_NUMBER = 1;
	private final int MAX_NUMBER = 9;
	
	private BaseballNumberList computerNumberList;
	
	public BaseballComputer(){
		validateSetting();
		Set<Integer> computerNumberSet = makeComputerNumberSet();
		String computerNumber = setToString(computerNumberSet);
		
		this.computerNumberList = new BaseballNumberList(computerNumber);
	}
	
	private Set<Integer> makeComputerNumberSet(){
		Set<Integer> computerNumberSet = new HashSet<Integer>();
		while(computerNumberSet.size() < NUMBER_LENGTH) {
			computerNumberSet.add(pickNumberInRange());
		}
		return computerNumberSet;
	}
	
	private int pickNumberInRange(){
		return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
	}
	
	private String setToString(Set<Integer> computerNumberSet) {
		StringBuffer sb = new StringBuffer();
		for(int computerNumber : computerNumberSet) {
			sb.append(computerNumber);
		}
		return sb.toString();
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

