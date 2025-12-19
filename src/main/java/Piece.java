import java.util.ArrayList;

public abstract class Piece {
    protected final PieceType type;
    protected final PieceColour colour;
    protected Position currentPosition;

    protected Piece(PieceType type, PieceColour colour) {
        this.type = type;
        this.colour = colour;
    }

    public PieceType getType() {
        return type;
    }
    public PieceColour getColour() {
        return colour;
    }
    public Position getCurrentPosition() {
        return currentPosition;
    }
    public void setCurrentPosition(Position newPosition) {
        currentPosition.setPosition(newPosition);
    }

    // Returns a list of all possible positions according to both the
    //  currentPosition of the piece and its specific move set
    // The pieces do not validate their own moves, they only give the list of all possible moves
    protected abstract ArrayList<Position> getAllMoves();
}
