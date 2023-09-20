

public class ChessPiece {
    protected Coordinates coord;
    protected Color color;

    public ChessPiece(Color color) {
        this.color = color;
    }


     enum Color{
        WHITE,
        BLACK
    }
}
