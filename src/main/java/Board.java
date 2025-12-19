public class Board {
    private final int rows;
    private final int columns;
    private final BoardCell[][] grid;

    public Board() {
        this.rows = 8;
        this.columns = 8;
        this.grid = new BoardCell[8][8];
        initializeCells(8, 8);
    }

    public Board(int numRows, int numColumns) {
        this.rows = numRows;
        this.columns = numColumns;
        this.grid = new BoardCell[rows][columns];
        initializeCells(rows, columns);
    }

    private void initializeCells(int numRows, int numCols) {
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                this.grid[i][j] = new BoardCell();
            }
        }
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

    public void addPiece(Piece piece, int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= columns) {
            throw new ArrayIndexOutOfBoundsException();
        }

        // Add the piece to the boardCell at the row and column
        grid[row][col].setCurrentPiece(piece);
    }

    public String getGridString() {
        // |R|N|B|K|Q|B|N|R| 0 <- WHITE
        // |P|P|P|P|P|P|P|P| 1
        // | | | | | | | | | 2
        // | | | | | | | | | 3
        // | | | | | | | | | 4
        // | | | | | | | | | 5
        // |P|P|P|P|P|P|P|P| 6
        // |R|N|B|K|Q|B|N|R| 7 <- BLACK

        StringBuilder sb = new StringBuilder();

        // Loop through the boardCells of the grid
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                // Add the char of the piece at the current boardCell
                sb.append('|');
                sb.append(getPieceChar(grid[row][col].getCurrentPiece()));
            }
            sb.append("|\n");
        }

        return sb.toString();
    }

    private char getPieceChar(Piece piece) {
        return switch (piece.getType()) {
            case PAWN -> 'P';
            case ROOK -> 'R';
            case KNIGHT -> 'N';
            case BISHOP -> 'B';
            case QUEEN -> 'Q';
            case KING -> 'K';
            default -> ' ';
        };
    }
}
