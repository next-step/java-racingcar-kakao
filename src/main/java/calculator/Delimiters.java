package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Delimiters {

    private static final List<String> DEFAULT_DELIMITERS = Arrays.asList(",", ":");
    private final List<String> delimiters;

    public Delimiters() {
        delimiters = new ArrayList<>(DEFAULT_DELIMITERS);
    }

    public List<String> split(String input) {
        return Arrays.asList(input.split(this.makeRegex()));
    }

    private String makeRegex() {
        return "[" + String.join("", delimiters) + "]";
    }

    public void addCustomDelimiter(String newDelimiter) {
        delimiters.add(newDelimiter);
    }
}