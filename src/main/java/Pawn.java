import java.util.ArrayList;

public class Pawn extends Piece {
    private boolean firstMove;

    public Pawn(PieceColour colour) {
        super(PieceType.PAWN, colour);
        firstMove = true;
    }

    public boolean isFirstMove() {
        return firstMove;
    }
    public void setMoved() {
        firstMove = false;
    }

    // Pawn can step twice in front on its first move
    // Otherwise it can step up once in the front
    // If there is another piece on either corner (pawn class won't check for this),
    //  then the pawn can move to those squares too
    public ArrayList<Position> getAllMoves() {
        int row = currentPosition.getRow();
        int col = currentPosition.getCol();
        ArrayList<Position> allMoves = new ArrayList<>();

        if (colour == PieceColour.WHITE) {
            allMoves.add(new Position(row + 1, col)); // one step forward
            allMoves.add(new Position(row + 1, col - 1)); // one step forward-left
            allMoves.add(new Position(row + 1, col + 1)); // one step forward-right
            if (firstMove) { allMoves.add(new Position(row + 2, col)); } // two steps forward
        } else {
            allMoves.add(new Position(row - 1, col)); // one step 'forward' for black
            allMoves.add(new Position(row - 1, col + 1)); // one step forward-left
            allMoves.add(new Position(row - 1, col - 1)); // one step forward-right
            if (firstMove) { allMoves.add(new Position(row - 2, col)); } // two steps forward
        }

        return allMoves;
    }
}
