package baseball;

import java.util.HashSet;
import java.util.Set;

public class BaseballNumberList {
	
	public BaseballNumberList(String numbers) {
		validate(numbers);
	}
	
	private void validate(String numbers) {
		validateCount(numbers);
		validateOverlap(numbers);
		validateRange(numbers);
	}

	private void validateCount(String numbers) {
		if(numbers.length() != 3) {
            throw new IllegalArgumentException("BaseballNumberList count error");
		}
	}
	
	private void validateOverlap(String numbers) {
		Set<Character> numberSet = StringToSet(numbers);
		
		if(numberSet.size() != 3) {
            throw new IllegalArgumentException("BaseballNumberList overlap error");
		}
	}
	
	private Set<Character> StringToSet(String numbers){
		Set<Character> numberSet = new HashSet<>();
		for(char number : numbers.toCharArray()) {
			numberSet.add(number);
		}
		return numberSet;
	}
	
	private void validateRange(String numbers) {
		for(char number : numbers.toCharArray()) {
			checkRange(number);
		}
	}
	
	private void checkRange(char number) {
		if(number < '1' || number > '9') {
            throw new IllegalArgumentException("BaseballNumber Range(1~9) error");
		}
	}
}
