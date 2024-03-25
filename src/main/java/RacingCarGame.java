public class RacingCarGame {

	private static final InputView inputView = new InputView();
	private static final OutputView outputView = new OutputView();

	public static void main(String[] args) {
		outputView.printGuide();
		String names = inputView.getNames();

		outputView.printTryCount();
		int number = inputView.getNumber();

		outputView.printResultGuid();
	}
}
