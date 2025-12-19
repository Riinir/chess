import java.util.ArrayList;

public class Knight extends Piece {
    public Knight(PieceColour colour) {
        super(PieceType.KNIGHT, colour);
    }

    public ArrayList<Position> getAllMoves() {
        return new ArrayList<>();
    }
}
