package racingCar;

import java.util.Random;

public class NumberGenerator {
	public int generateNumber(){
		Random rand = new Random();
		return rand.nextInt(10);
	}
}
