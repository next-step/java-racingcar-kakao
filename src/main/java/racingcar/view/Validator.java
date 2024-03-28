package racingcar.view;

public class Validator {
	public static final int NAME_LENGTH_BOUNDARY = 5;

	public static void wordLengthCheck(String carNames) {
		if (carNames.length() >= NAME_LENGTH_BOUNDARY) {
			throw new IllegalArgumentException("문자의 길이가 5 이상입니다.");
		}
	}
}
