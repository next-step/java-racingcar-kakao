import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("자동차 테스트")
public class CarTest {

	@Test
	@DisplayName("전진한다.")
	void go() {
		Car car = new Car("test");
		car.move(4);
		assertThat(car.getPosition()).isEqualTo(1);
	}

	@Test
	@DisplayName("이동하지 않는다.")
	void stop() {
		Car car = new Car("test");
		car.move(3);
		assertThat(car.getPosition()).isEqualTo(0);
	}
}
