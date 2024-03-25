import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Cars {

	private final List<Car> cars=new ArrayList<>();
	public Cars(String s) {
		String[] carNames = s.split(",");
		for(String carName : carNames){
			Car car=new Car(carName);
			this.cars.add(car);
		}
	}

	public List<String> getCarNames() {
		return cars.stream()
			.map(Car::getName)
			.collect(Collectors.toList());
	}

	public void move() {
		for(Car car : cars) {
			car.move(generateNumber());
		}
	}

	private int generateNumber(){
		Random rand = new Random();
		return rand.nextInt(10);
	}
}
