package racingcar.model;

import racingcar.generator.NumberGenerator;
import racingcar.generator.RandomNumberGenerator;

public class RacingCar {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_MOVE_THRESHOLD = 4;
    private static final int MAX_MOVE_THRESHOLD = 9;
    private NumberGenerator numberGenerator;
    private String name;
    private int moves = 0;

    public RacingCar() {
    }

    public RacingCar(String name) {
        this(name, new RandomNumberGenerator());
    }

    public RacingCar(String name, NumberGenerator numberGenerator) {
        validateName(name);
        this.name = name;
        this.numberGenerator = numberGenerator;
    }
    
    public void getNumAndMove(int num) {
        if (isMove(num)) {
            this.moves++;
        }
    }

    public void move() {
        int num = numberGenerator.generate();
        getNumAndMove(num);
    }

    public boolean isMove(int num) {
        return num >= MIN_MOVE_THRESHOLD && num <= MAX_MOVE_THRESHOLD;
    }

    public String getName() {
        return name;
    }

    public int getMoves() {
        return moves;
    }

    public boolean isAt(int moves) {
        return this.moves == moves;
    }

    private void validateName(String name) {
        if (name == null || name.isEmpty() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름이 적절하지 않습니다.");
        }
    }
}
