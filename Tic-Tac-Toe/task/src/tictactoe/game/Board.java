package tictactoe.game;

public class Board {
    private static final int ROWS = 3;
    private static final int COLUMNS = 3;

    private static final Cell[][] cells = new Cell[ROWS][COLUMNS];

    public Board() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    public void setValue(int rowIndex, int columnIndex, CellValue value) {
        Cell cell = cells[rowIndex][columnIndex];
        cell.setValue(value);
    }

    public CellValue getValue(int rowIndex, int columnIndex) {
        Cell cell = cells[rowIndex][columnIndex];
        return cell.getValue();
    }

    public Result getResult(int rowIndex, int columnIndex) {
        CellValue value = cells[rowIndex][columnIndex].getValue();
        if (rowMatch(rowIndex, value))
            return Result.WIN;
        if (columnMatch(columnIndex, value))
            return Result.WIN;
        if (diagonalMatch())
            return Result.WIN;
        return Result.DRAW;
    }

    private boolean diagonalMatch() {
        return ((cells[1][1].getValue() != CellValue.EMPTY) &&
                ((cells[0][0].getValue() == cells[1][1].getValue() &&
                        cells[1][1].getValue() == cells[2][2].getValue()) ||
                        (cells[0][2].getValue() == cells[1][1].getValue() &&
                                cells[1][1].getValue() == cells[2][0].getValue())));
    }

    private boolean columnMatch(int columnIndex, CellValue value) {
        for (int i = 0; i < ROWS; i++) {
            if (cells[i][columnIndex].getValue() != value) {
                return false;
            }

        }
        return true;
    }

    private boolean rowMatch(int rowIndex, CellValue value) {
        for (int i = 0; i < COLUMNS; i++) {
            if (cells[rowIndex][i].getValue() != value) {
                return false;
            }
        }
        return true;
    }

    public void print() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                Cell cell = cells[i][j];
                cell.print();
                System.out.print(" ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");
    }
}
