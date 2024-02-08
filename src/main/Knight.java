import java.util.ArrayList;
import java.util.List;

public class Knight extends ChessPiece {
    public Knight(Color color) {
        super(color);
    }

    @Override
    public Coordinates[] getValidMoves() {
        List<Coordinates> moves = new ArrayList<>();
        int x = coord.getX();
        int y = coord.getY();
        if (y >= 2) {    //checking if Knight won't go beyond the board
            if (x <= 6) moves.add(coord.offset(1,-2));
            if (x >= 1) moves.add(coord.offset(-1,-2));
        }
        if (y >= 1) {
            if (x <= 5) moves.add(coord.offset(2,-1));
            if (x >= 2) moves.add(coord.offset(-2,-1));
        }
        if (y <= 6) {
            if (x <= 5) moves.add(coord.offset(2,1));
            if (x >= 2) moves.add(coord.offset(-2,1));
        }
        if (y <= 5) {
            if (x <= 6) moves.add(coord.offset(1,2));
            if (x >= 1) moves.add(coord.offset(-1,2));
        }
        return moves.toArray(new Coordinates[moves.size()]);
    }
}
