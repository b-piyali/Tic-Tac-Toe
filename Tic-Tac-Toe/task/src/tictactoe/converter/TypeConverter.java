package tictactoe.converter;

import tictactoe.predicate.NumberValidator;

import java.util.function.Function;

public class TypeConverter implements Function<String, Integer> {
    private static final NumberValidator NUMBER_VALIDATOR = new NumberValidator();

    @Override
    public Integer apply(String s) {
        if (!NUMBER_VALIDATOR.test(s)) {
            throw new IllegalArgumentException("You should enter numbers!");
        }
        return Integer.parseInt(s);
    }
}
