import java.util.ArrayList;
import java.util.List;

public class Knight extends ChessPiece {
    public Knight(Color color) {
        super(color);
    }

    @Override
    public Coordinates[] getValidMoves() {
        List<Coordinates> moves = new ArrayList<>();
        if (coord.getY() >= 2) {    //checking if Knight won't go beyond the board
            if (coord.getX() <= 6) moves.add(new Coordinates(coord.getX(), coord.getY()).offset(1,-2));
            if (coord.getX() >= 1) moves.add(new Coordinates(coord.getX(), coord.getY()).offset(-1,-2));
        }
        if (coord.getY() >= 1) {
            if (coord.getX() <= 5) moves.add(new Coordinates(coord.getX(), coord.getY()).offset(2,-1));
            if (coord.getX() >= 2) moves.add(new Coordinates(coord.getX(), coord.getY()).offset(-2,-1));
        }
        if (coord.getY() <= 6) {
            if (coord.getX() <= 5) moves.add(new Coordinates(coord.getX(), coord.getY()).offset(2,1));
            if (coord.getX() >= 2) moves.add(new Coordinates(coord.getX(), coord.getY()).offset(-2,1));
        }
        if (coord.getY() <= 5) {
            if (coord.getX() <= 6) moves.add(new Coordinates(coord.getX(), coord.getY()).offset(1,2));
            if (coord.getX() >= 1) moves.add(new Coordinates(coord.getX(), coord.getY()).offset(-1,2));
        }
        return moves.toArray(new Coordinates[moves.size()]);
    }
}
