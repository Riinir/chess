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

    // This method returns a list of positions according to the currentPosition
    //  of the piece as well as its specific move set
    protected abstract ArrayList<Position> getAllMoves();
}
