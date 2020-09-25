package tictactoe.predicate;

import java.util.function.BiPredicate;

public class CoordinateValidator implements BiPredicate<Integer, Integer> {
    @Override
    public boolean test(Integer rowCoordinate, Integer colCoordinate) {
        return (colCoordinate > 0 && colCoordinate < 4) && (rowCoordinate > 0 && rowCoordinate < 4);
    }
}
