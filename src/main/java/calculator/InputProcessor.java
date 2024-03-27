package calculator;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputProcessor {

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n");

    public void validateInput(String input) {
        String regex = "^(?://.\n)?(?:\\d[:," + parseCustomDelimiter(input).orElse("") + "])*\\d+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid input format");
        }
    }

    public Optional<String> parseCustomDelimiter(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);

        if (matcher.find()) {
            return Optional.ofNullable(matcher.group(1));
        }
        return Optional.empty();
    }
}
