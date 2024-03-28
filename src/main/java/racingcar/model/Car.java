package racingcar.model;

import static racingcar.view.Validator.*;

public class Car {
	private static final int MOVEMENT_THRESHOLD = 3;

	private int position;
	private String name;

	public Car() {
	}

	public Car(String name) {
		this(name, 0);
	}

	public Car(String name, int position) {
		wordLengthCheck(name);
		this.name = name;
		this.position = position;
	}

	public int moveForwardIfCan(int number) {
		if (number > MOVEMENT_THRESHOLD) {
			this.position++;
		}

		return position;
	}

	public int getPosition() {
		return position;
	}

	public String getName() {
		return name;
	}
}
