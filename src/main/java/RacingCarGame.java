public class RacingCarGame {

	private static final InputView inputView = new InputView();
	private static final OutputView outputView = new OutputView();

	public static void main(String[] args) {
		outputView.printGuide();
		String names = inputView.getNames();
		Cars cars = new Cars(names);

		outputView.printTryCount();
		int number = inputView.getNumber();

		outputView.printResultGuide();
		for(int i=0;i<number;i++){
			cars.move(new NumberGenerator());
			outputView.printResult(cars);
		}

		outputView.printWinners(cars.getWinners());
	}
}
