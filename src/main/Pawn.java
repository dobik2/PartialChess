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
            if(coord.getY() > 0)moves.add(new Coordinates(coord.getX(), coord.getY()).offset(0,-1));
            if(coord.getY() == 6)moves.add(new Coordinates(coord.getX(), coord.getY()).offset(0,-2));
            if(coord.getX() < 7)moves.add(new Coordinates(coord.getX(), coord.getY()).offset(1,-1));
            if(coord.getX() > 0)moves.add(new Coordinates(coord.getX(), coord.getY()).offset(-1,-1));
        }
        else{
            if(coord.getY() < 7)moves.add(new Coordinates(coord.getX(), coord.getY()).offset(0,1));
            if(coord.getY() == 1)moves.add(new Coordinates(coord.getX(), coord.getY()).offset(0,2));
            if(coord.getX() < 7)moves.add(new Coordinates(coord.getX(), coord.getY()).offset(1,1));
            if(coord.getX() > 0)moves.add(new Coordinates(coord.getX(), coord.getY()).offset(-1,1));
        }
        return moves.toArray(new Coordinates[moves.size()]);
    }
}
