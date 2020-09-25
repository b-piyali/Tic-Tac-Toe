package tictactoe.game;

import java.util.Objects;

public class Cell {
    private CellValue value = CellValue.EMPTY;

    public boolean isEmpty() {
        return this.value == CellValue.EMPTY;
    }

    public void setValue(CellValue value) {
        if (isEmpty()) {
            this.value = value;
            return;
        }
        throw new IllegalStateException("This cell is occupied! Choose another one!");
    }

    public CellValue getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (Objects.nonNull(o)) {
            if (o == this) return true;
            if (o instanceof Cell) {
                return ((Cell) o).value == this.value;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.value);
    }

    public void print() {
        System.out.print(this.value.getValue());
    }
}
