package racing.validator;

import java.util.regex.Pattern;

public class CarNameValidator implements Validator{

    @Override
    public boolean validate(String text) {
        return Pattern.matches("^[a-zA-Z0-9]{1,5}(,[a-zA-Z]{1,5})*$", text);
    }
}
