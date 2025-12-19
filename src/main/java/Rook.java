import java.util.ArrayList;

public class Rook extends Piece {
    private boolean firstMove;

    public Rook(PieceColour colour) {
        super(PieceType.ROOK, colour);
    }

    public ArrayList<Position> getAllMoves() {
        return new ArrayList<>();
    }
}
