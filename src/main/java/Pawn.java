import java.util.ArrayList;

public class Pawn extends Piece {
    private boolean firstMove;

    public Pawn(PieceColour colour) {
        super(PieceType.PAWN, colour);
    }

    public ArrayList<Position> getAllMoves() {
        return new ArrayList<>();
    }
}
