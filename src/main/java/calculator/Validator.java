package calculator;

public class Validator {

    public int check(String token){
        int num = 0;
        try {
            num = Integer.parseInt(token);
            isMinus(num);
        } catch (Exception e) {
            throw new IllegalArgumentException("음수 또는 문자형이 들어가있습니다.");
        }
        return num;
    }
    private void isMinus(int num){
        if (num < 0) {
            throw new IllegalArgumentException();
        }
    }
}
