 // Every piece will have a position that can change

 import java.util.Objects;

 public class Position {
    private int row;
    private int col;

    public Position() {
        row = -1;
        col = -1;
    }

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || other.getClass() != this.getClass()) { return false; }

        Position p = (Position) other;
        return (p.getRow() == row) && (p.getCol() == col);
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }

    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public int getCol() {
        return col;
    }
    public void setCol(int col) {
        this.col = col;
    }

    public void setPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }
    public void setPosition(Position other) {
        this.row = other.getRow();
        this.col = other.getCol();
    }
}
