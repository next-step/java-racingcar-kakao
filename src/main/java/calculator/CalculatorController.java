package calculator;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CalculatorController {

    public CalculatorController() {
    }

    public int add(String input) {
        input = input.replace("\\n", "\n");
        validateInput(input);
        Delimiter delimiter = new Delimiter();
        delimiter.addCustomDelimiter(parseCustomDelimiter(input).orElse(""));
        List<Integer> numbers = parseNumber(input);
        return numbers.stream().reduce(0, Integer::sum);
    }

    public void validateInput(String input) {
        String regex = "^(?://.\n)?(?:\\d[:," + parseCustomDelimiter(input).orElse("") + "])*\\d+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid input format");
        }
    }

    public Optional<String> parseCustomDelimiter(String input) {
        String regex = "//(.)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            return Optional.ofNullable(matcher.group(1));
        }
        return Optional.empty();
    }

    private List<Integer> parseNumber(String input) {
        input = input.replaceAll("//(.*)\n", "");
        Delimiter delimiter = new Delimiter();
        return delimiter.split(input).stream().map(Integer::parseInt).collect(Collectors.toList());
    }
}
