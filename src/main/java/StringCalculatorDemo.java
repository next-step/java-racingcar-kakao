import strcalc.StringCalculator;

public class StringCalculatorDemo {

    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculator();
        System.out.printf("1,2;3 = " + calculator.add("1,2;3") + "\n");
        System.out.printf("//;\\n1;2;3 = " + calculator.add("//;\n1;2;3") + "\n");
        System.out.printf("//a|i\\n1a2i3 = " + calculator.add("//a|i\n1a2i3") + "\n");
    }
}