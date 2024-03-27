package racingCar;

public class Car {
	private String name;
	private int position;

	public Car(String name) {
		validateName(name);
		this.name = name;
		this.position = 0;
	}

	private void validateName(String name) {
		if (name.length() > 5)
			throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
	}

	public void move(int number) {
		if(number>3){
			this.position++;
		}
	}

	public int getPosition() {
		return this.position;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
	 	return name + " : " + "-".repeat(position);
	}
}
