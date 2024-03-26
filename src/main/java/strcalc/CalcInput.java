package strcalc;

public class CalcInput {
    private final String text;
    private final String delimiter;

    public CalcInput(String text, String delimiter) {
        this.text = text;
        this.delimiter = delimiter;
    }

    public String getText() {
        return text;
    }

    public String getDelimiter() {
        return delimiter;
    }

}