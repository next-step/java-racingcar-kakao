package racing.validator;

import java.util.regex.Pattern;

public class TryCountValidator implements Validator{

    @Override
    public boolean validate(String text) {
        return Pattern.matches("^\\d+$", text);
    }
}
