package calculator;

public class Validator {
    public void validate(String expression, Delimiter delimiter) {
        for (String token : expression.split("")) {
            checkInvalidToken(token, delimiter);
        }
    }

    private boolean isDigit(String token) {
        char tokenChar = token.charAt(0);

        return '0' <= tokenChar && tokenChar <= '9';
    }

    private void checkInvalidToken(String token, Delimiter delimiter) {
        if (!(delimiter.contains(token) || isDigit(token))) {
            throw new RuntimeException();
        }
    }
}
