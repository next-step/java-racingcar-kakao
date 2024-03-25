package car;

public class Car {
    private int position;

    public int generateRandomNumber() {
        return (int) (Math.random() * 10);
    }



    public int getPosition() {
        return position;
    }

    public void run(int randomNumber) {
        if (randomNumber >= 4) {
            position += 1;
        }
    }
}
