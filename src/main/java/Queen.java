import java.util.ArrayList;

public class Queen extends Piece {
    public Queen(PieceColour colour) {
        super(PieceType.QUEEN, colour);
    }

    public ArrayList<Position> getAllMoves() {
        return new ArrayList<>();
    }
}
