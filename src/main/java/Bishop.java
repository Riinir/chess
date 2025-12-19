import java.util.ArrayList;

public class Bishop extends Piece {
    public Bishop(PieceColour colour) {
        super(PieceType.BISHOP, colour);
    }

    public ArrayList<Position> getAllMoves() {
        return new ArrayList<>();
    }
}
