import java.util.ArrayList;

// Singleton class - the same nonePiece is used every time
public class NonePiece extends Piece {
    public static final NonePiece instance = new NonePiece();

    private NonePiece() {
        super(PieceType.NONE, PieceColour.NONE);
    }

    public static synchronized Piece getInstance() {
        return instance;
    }

    public ArrayList<Position> getAllMoves() {
        return new ArrayList<>();
    }
}
