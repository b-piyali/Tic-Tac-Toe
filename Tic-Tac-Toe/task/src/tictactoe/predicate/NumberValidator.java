package tictactoe.predicate;

import java.util.Objects;
import java.util.function.Predicate;

public class NumberValidator implements Predicate<String> {
    @Override
    public boolean test(String number) {
        if (Objects.isNull(number)) return false;

        try {
            int n = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
