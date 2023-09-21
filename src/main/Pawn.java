import java.util.ArrayList;
import java.util.List;

public class Pawn extends ChessPiece{

    public Pawn(Color color) {
        super(color);
    }

    @Override
    public Coordinates[] getValidMoves() {
        List<Coordinates> moves = new ArrayList<>();

        if(color == Color.WHITE){
            if(coord.getX() == 6)moves.add(new Coordinates(4, coord.getY()));
            moves.add(new Coordinates(coord.getX() - 1, coord.getY()));
        }

        return moves.toArray(new Coordinates[moves.size()]);
    }
}
