package racing.domain;

import racing.generator.NumberGenerator;

public class Car {
    private final String carName;
    private final NumberGenerator numberGenerator;
    private int position;
    private final int THRESHOLD = 3;

    public Car(String carName, NumberGenerator numberGenerator) {
        this.carName = carName;
        this.numberGenerator = numberGenerator;
        this.position = 0;
    }

    public int proceed() {
        int number = numberGenerator.generate();
        if (this.canGo(number)) {
            this.position++;
        }

        return this.position;
    }

    public String getCarName() {
        return this.carName;
    }

    public int getPosition() {
        return this.position;
    }

    private boolean canGo(int number) {
        return (number > THRESHOLD);
    }
}
