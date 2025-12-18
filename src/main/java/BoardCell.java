public class BoardCell {
    private Piece currentPiece;
    private boolean isEmpty;

    public BoardCell() {
        currentPiece = NonePiece.getInstance();
        isEmpty = true;
    }

    public boolean isEmpty() {
        return isEmpty;
    }
    public void setEmpty(boolean state) {
        isEmpty = state;
    }

    public Piece getCurrentPiece() {
        return currentPiece;
    }
    public void setCurrentPiece(Piece newPiece) {
        currentPiece = newPiece;
        if (newPiece.getType() != PieceType.NONE) { setEmpty(false); }
    }
    public void removeCurrentPiece() {
        currentPiece = NonePiece.getInstance();
        setEmpty(true);
    }
}
