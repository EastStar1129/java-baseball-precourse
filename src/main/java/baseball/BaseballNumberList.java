package baseball;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class BaseballNumberList {
	
	private List<Character> numberList;

	public BaseballNumberList(String numbers) {
		Set<Character> numberSet = stringToSet(numbers);
		validate(numberSet);
		this.numberList = setToList(numberSet);
	}
	
	public BaseballNumberList(Set<Character> numberSet) {
		validate(numberSet);
		this.numberList = setToList(numberSet);
	}
	
	public List<Character> getNumberList(){
		return this.numberList;
	}
	
	private Set<Character> stringToSet(String numbers){
		Set<Character> numberSet = new LinkedHashSet<Character>();
		for(char number : numbers.toCharArray()) {
			numberSet.add(number);
		}
		return numberSet;
	}
	
	private List<Character> setToList(Set<Character> numberSet) {
		return new ArrayList<>(numberSet);
	}
	
	private void validate(Set<Character> numberSet) {
		validateOverlap(numberSet);
		validateRange(numberSet);
	}
	
	private void validateOverlap(Set<Character> numberSet) {
		if(numberSet.size() != 3) {
            throw new IllegalArgumentException("BaseballNumberList size error");
		}
	}
	
	private void validateRange(Set<Character> numberSet) {
		for(char number : numberSet) {
			checkRange(number);
		}
	}
	
	private void checkRange(char number) {
		if(number < '1' || number > '9') {
            throw new IllegalArgumentException("BaseballNumber Range(1~9) error");
		}
	}
}
