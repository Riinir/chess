 // Every piece will have a position that can change

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

    public void setPosition(Position other) {
        this.row = other.getRow();
        this.col = other.getCol();
    }
}
