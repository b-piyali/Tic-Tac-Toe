package tictactoe;

import tictactoe.converter.CoordinateConverter;
import tictactoe.game.Board;
import tictactoe.game.CellValue;
import tictactoe.game.Result;

import java.util.Scanner;

public class Main {
    private static final CoordinateConverter COORDINATE_CONVERTER = new CoordinateConverter();

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();
        int count = 0;
        boolean gameFinished = false;
        board.print();
        CellValue value;
        Result result;

        int colIndex;
        int rowIndex;
        while (!gameFinished) {
            System.out.println("Enter the coordinates: ");
            String inputIndexes = scanner.nextLine();
            String[] pieces = inputIndexes.split(" ");
            try {
                Integer[] indexes = COORDINATE_CONVERTER.apply(pieces);
                rowIndex = indexes[0];
                colIndex = indexes[1];
                value = count % 2 == 0 ? CellValue.X : CellValue.O;
                board.setValue(rowIndex, colIndex, value);
                board.print();
                count++;

                result = board.getResult(rowIndex, colIndex);
                if (result == Result.WIN) {
                    if (value == CellValue.X) {
                        System.out.println("X wins");
                    } else {
                        System.out.println("O wins");
                    }
                    gameFinished = true;
                } else if (count == 9 && result == Result.DRAW) {
                    System.out.println("Draw");
                    gameFinished = true;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
