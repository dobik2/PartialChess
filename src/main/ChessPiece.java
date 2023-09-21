

public abstract class ChessPiece {
    protected Coordinates coord;
    protected Color color;

    public ChessPiece(Color color) {
        this.color = color;
    }

    public void setCoordinates(Coordinates coord) {
        this.coord = coord;
    }

    public abstract Coordinates[] getValidMoves();

    enum Color{
        WHITE,
        BLACK
    }


}
