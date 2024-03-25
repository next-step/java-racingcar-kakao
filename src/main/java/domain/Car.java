package domain;

public class Car {
    public int position;
    public String name;

    public void checkForwardMotion(int i) {
        if(i<=3){
            return;
        }
        position++;
    }

    public Car(){

    }

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }
}
