package racingcar;

import java.util.Objects;

public class Car implements Comparable<Car>{

	private final String name;
	private int position;

	public Car(String name) {
		this(name, 0);
	}

	public Car(String name, int position) {
		this.name = name;
		this.position = position;
	}

	public void proceed() {
		this.position += 1;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Car car = (Car)o;
		return position == car.position && Objects.equals(name, car.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, position);
	}

	@Override
	public int compareTo(Car other) {
		return other.position - this.position;
	}
}
