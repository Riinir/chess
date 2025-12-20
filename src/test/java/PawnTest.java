import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class PawnTest {
    Board board = new Board(8, 8);
    Pawn whitePawn;
    Pawn blackPawn;

    @BeforeEach
    void setup() {
        // Point to new pawns to reset isFirstMove boolean
        whitePawn = new Pawn(PieceColour.WHITE);
        blackPawn = new Pawn(PieceColour.BLACK);
    }

    /**
     * Piece class tests
     */
    @Test
    void getColourTest() {
        Assertions.assertSame(PieceColour.WHITE, whitePawn.getColour());
    }
    @Test
    void setNewPosition() {
        whitePawn.setCurrentPosition(0, 0);
        Assertions.assertEquals(new Position(0,0), whitePawn.getCurrentPosition());
    }
    @Test
    void setPositionNegative() {
        // The position class has no information about the board, it is just two coordinates, so -position is okay
        whitePawn.setCurrentPosition(new Position()); // default position is -1, -1
        Assertions.assertEquals(new Position(-1,-1), whitePawn.getCurrentPosition());
    }

    // GetAllMoves: black, white, on the edge/corner of the board, first move
    @Test
    void firstMoveInitialState() {
        Assertions.assertTrue(whitePawn.isFirstMove());
    }
    @Test
    void setMovedOnce() {
        whitePawn.setMoved();
        Assertions.assertFalse(whitePawn.isFirstMove());
    }
    @Test
    void setMovedTwice() {
        whitePawn.setMoved();
        whitePawn.setMoved();
        Assertions.assertFalse(whitePawn.isFirstMove());
    }

    @Test
    void getBlackMoves() {

    }

    @Test
    void getWhiteMoves() {

    }

}
