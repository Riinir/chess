import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoardTest {
    @Test
    void addOnePawn() {
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
    void addNonePiece() {
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
    void addFullLineup() {
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
    void fillEntireBoard() {
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
