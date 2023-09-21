public class Knight extends ChessPiece{
    public Knight(Color color) {
        super(color);
    }

    @Override
    public Coordinates[] getValidMoves() {
        return new Coordinates[0];
    }
}
