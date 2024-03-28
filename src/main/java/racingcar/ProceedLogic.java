package racingcar;

public class ProceedLogic {
	private static final int PROCEED_THRESHOLD = 3;
	private final NumberGenerator numberGenerator;
	public ProceedLogic(NumberGenerator numberGenerator) {
		this.numberGenerator = numberGenerator;
	}

	public boolean askProceed() {
		return numberGenerator.generate() > PROCEED_THRESHOLD;
	}
}
