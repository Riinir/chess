public class Board {
    private final int rows;
    private final int columns;
    private final BoardCell[][] grid;

    public Board(int numRows, int numColumns) {
        this.rows = numRows;
        this.columns = numColumns;
        this.grid = new BoardCell[rows][columns];
    }

    public int getColumns() {
        return columns;
    }
    public int getRows() {
        return rows;
    }
    public BoardCell[][] getGrid() {
        return grid;
    }
}
