package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Delimiter {

    private static final List<String> INITIAL_DELIMITERS = Arrays.asList(",", ":");
    private final List<String> delimiters;

    public Delimiter() {
        delimiters = new ArrayList<>(INITIAL_DELIMITERS);
    }

    public List<String> split(String s) {
        return Arrays.asList(s.split(this.makeRegex()));
    }

    private String makeRegex() {
        return "[" + String.join("", delimiters) + "]";
    }

    public void addCustomDelimiter(String newDelimiter) {
        delimiters.add(newDelimiter);
    }
}
