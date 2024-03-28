package calculator;

public class Validator {

    private static final int NUMBER_ZERO = 0;

    public static int isPositiveInteger(String token){
        int num = 0;
        try {
            num = Integer.parseInt(token);
            isMinus(num);
        } catch (Exception e) {
            throw new IllegalArgumentException("음수 또는 문자형이 들어가있습니다.");
        }
        return num;
    }

    private static void isMinus(int num){
        if (num < NUMBER_ZERO) {
            throw new IllegalArgumentException();
        }
    }
}
