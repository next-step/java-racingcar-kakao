package calculator;

import java.util.List;

public final class Parser {
    private Parser(String input) {

    }

    public static Parser of(String input) {
        return new Parser(input);
    }

    public Numbers parse() {
        return Numbers.of(List.of(1, 2, 3));
    }
}
