package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.model.Car;

@DisplayName("자동차 객체 테스트")
public class CarTest {

	Car car;

	@BeforeEach
	void setUp() {
		car = new Car();
	}

	@Test
	@DisplayName("차 생성 이름 테스트")
	void createCarNameTest() {
		String input = "test";
		car = new Car(input);
		assertThat(car.getName()).isEqualTo(input);
	}

	@Test
	@DisplayName("전진 테스트")
	void forwardTest() {
		car.moveForwardIfCan(5);
		assertThat(car.getPosition()).isEqualTo(1);
	}

	@Test
	@DisplayName("정지 테스트")
	void stayTest() {
		car.moveForwardIfCan(3);
		assertThat(car.getPosition()).isEqualTo(0);
	}
}
