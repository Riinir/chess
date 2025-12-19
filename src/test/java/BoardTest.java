import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoardTest {
    @Test
    void addPieceLastRowAndCol() {
        Board board = new Board(8, 8);
        Pawn pawn = new Pawn(PieceColour.WHITE);
        board.addPiece(pawn, 7, 7);

        Assertions.assertSame(pawn, board.getGrid()[7][7].getCurrentPiece());
    }
    @Test
    void addPieceFirstRowAndCol() {
        Board board = new Board(8, 8);
        Pawn pawn = new Pawn(PieceColour.WHITE);
        board.addPiece(pawn, 0, 0);

        Assertions.assertSame(pawn, board.getGrid()[0][0].getCurrentPiece());
    }

    @Test
    void addPieceRowLessThanZero() {
        Board board = new Board();

        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> board.addPiece(new Pawn(PieceColour.WHITE), -1, 2));
    }
    @Test
    void addPieceRowEqualToNumRows() {
        Board board = new Board(8, 8);

        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> board.addPiece(new Pawn(PieceColour.WHITE), 8, 2));
    }
    @Test
    void addPieceRowGreaterThanNumRows() {
        Board board = new Board(8, 8);

        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> board.addPiece(new Pawn(PieceColour.WHITE), 9, 2));
    }

    @Test
    void addPieceColLessThanZero() {
        Board board = new Board();

        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> board.addPiece(new Pawn(PieceColour.WHITE), 2, -1));
    }
    @Test
    void addPieceColEqualToNumCols() {
        Board board = new Board(8, 8);

        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> board.addPiece(new Pawn(PieceColour.WHITE), 2, 8));
    }
    @Test
    void addPieceColGreaterThanNumCols() {
        Board board = new Board(8, 8);

        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> board.addPiece(new Pawn(PieceColour.WHITE), 2, 9));
    }

    @Test
    void displayEmptyBoard() {
        Board board = new Board();

        String expected =
                """
                | | | | | | | | |
                | | | | | | | | |
                | | | | | | | | |
                | | | | | | | | |
                | | | | | | | | |
                | | | | | | | | |
                | | | | | | | | |
                | | | | | | | | |
                """;
        String actual = board.getGridString();

        Assertions.assertEquals(expected, actual);
    }
    @Test
    void displayOnePawn() {
        Board board = new Board();
        Pawn pawn = new Pawn(PieceColour.WHITE);
        board.addPiece(pawn, 0, 0);

        String expected =
                """
                |P| | | | | | | |
                | | | | | | | | |
                | | | | | | | | |
                | | | | | | | | |
                | | | | | | | | |
                | | | | | | | | |
                | | | | | | | | |
                | | | | | | | | |
                """;
        String actual = board.getGridString();

        Assertions.assertEquals(expected, actual);
    }
    @Test
    void displayNonePiece() {
        Board board = new Board();
        Piece none = NonePiece.getInstance();
        board.addPiece(none, 5, 5);

        String expected =
                """
                | | | | | | | | |
                | | | | | | | | |
                | | | | | | | | |
                | | | | | | | | |
                | | | | | | | | |
                | | | | | | | | |
                | | | | | | | | |
                | | | | | | | | |
                """;
        String actual = board.getGridString();

        Assertions.assertEquals(expected, actual);
    }
    @Test
    void displayFullLineup() {
        Board board = new Board();
        for (int i = 0; i < 8; i++) {
            board.addPiece(new Pawn(PieceColour.WHITE), 1, i);
        }
        board.addPiece(new Rook(PieceColour.WHITE), 0, 0);
        board.addPiece(new Rook(PieceColour.WHITE), 0, 7);
        board.addPiece(new Knight(PieceColour.WHITE), 0, 1);
        board.addPiece(new Knight(PieceColour.WHITE), 0, 6);
        board.addPiece(new Bishop(PieceColour.WHITE), 0, 2);
        board.addPiece(new Bishop(PieceColour.WHITE), 0, 5);
        board.addPiece(new King(PieceColour.WHITE), 0, 3);
        board.addPiece(new Queen(PieceColour.WHITE), 0, 4);

        for (int i = 0; i < 8; i++) {
            board.addPiece(new Pawn(PieceColour.BLACK), 6, i);
        }
        board.addPiece(new Rook(PieceColour.BLACK), 7, 0);
        board.addPiece(new Rook(PieceColour.BLACK), 7, 7);
        board.addPiece(new Knight(PieceColour.BLACK), 7, 1);
        board.addPiece(new Knight(PieceColour.BLACK), 7, 6);
        board.addPiece(new Bishop(PieceColour.BLACK), 7, 2);
        board.addPiece(new Bishop(PieceColour.BLACK), 7, 5);
        board.addPiece(new King(PieceColour.BLACK), 7, 3);
        board.addPiece(new Queen(PieceColour.BLACK), 7, 4);

        String expected =
                """
                |R|N|B|K|Q|B|N|R|
                |P|P|P|P|P|P|P|P|
                | | | | | | | | |
                | | | | | | | | |
                | | | | | | | | |
                | | | | | | | | |
                |P|P|P|P|P|P|P|P|
                |R|N|B|K|Q|B|N|R|
                """;
        String actual = board.getGridString();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void fillAndDisplayEntireBoard() {
        Board board = new Board();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board.addPiece(new Pawn(PieceColour.WHITE), i, j);
            }
        }

        String expected =
                """
                |P|P|P|P|P|P|P|P|
                |P|P|P|P|P|P|P|P|
                |P|P|P|P|P|P|P|P|
                |P|P|P|P|P|P|P|P|
                |P|P|P|P|P|P|P|P|
                |P|P|P|P|P|P|P|P|
                |P|P|P|P|P|P|P|P|
                |P|P|P|P|P|P|P|P|
                """;
        String actual = board.getGridString();

        Assertions.assertEquals(expected, actual);
    }
}
