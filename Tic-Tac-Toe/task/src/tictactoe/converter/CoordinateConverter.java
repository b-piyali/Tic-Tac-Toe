package tictactoe.converter;

import tictactoe.predicate.CoordinateValidator;

import java.util.function.Function;

public class CoordinateConverter implements Function<String[], Integer[]> {
    private static final TypeConverter TYPE_CONVERTER = new TypeConverter();
    private static final CoordinateValidator COORDINATE_VALIDATOR = new CoordinateValidator();

    @Override
    public Integer[] apply(String[] coordinates) throws IllegalArgumentException {
        int colCoordinate = TYPE_CONVERTER.apply(coordinates[0]);
        int rowCoordinate = TYPE_CONVERTER.apply(coordinates[1]);

        if (!COORDINATE_VALIDATOR.test(rowCoordinate, colCoordinate))
            throw new IllegalArgumentException("Coordinates should be from 1 to 3!");

        Integer[] indexes = new Integer[2];
        indexes[0] = Math.abs(rowCoordinate - 3); // row index
        indexes[1] = Math.abs(colCoordinate - 1); // col index

        return indexes;
    }
}
