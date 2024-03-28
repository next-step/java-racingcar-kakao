package calculator;


import java.util.*;
import java.util.stream.Collectors;

public class Splitter {
    public List<Integer> split(String expression, Delimiter delimiter) {
        String delimiters = delimiter.getDelimiter();
        List<String> numberList = Arrays.asList(expression.split(delimiters));

        return numberList.stream().map(Integer::parseInt).collect(Collectors.toList());
    }
}
