import java.util.ArrayList;

public class King extends Piece {
    private boolean firstMove;

    public King(PieceColour colour) {
        super(PieceType.KING, colour);
    }

    public ArrayList<Position> getAllMoves() {
        return new ArrayList<>();
    }
}
