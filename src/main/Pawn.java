import java.util.ArrayList;
import java.util.List;

public class Pawn extends ChessPiece{

    public Pawn(Color color) {
        super(color);
    }

    @Override
    public Coordinates[] getValidMoves() {
        List<Coordinates> moves = new ArrayList<>();
        int x = coord.getX();
        int y = coord.getY();
        if(color == Color.WHITE){
            if(y > 0)moves.add( coord.offset(0,-1 ));
            if(y == 6)moves.add( coord.offset(0,-2 ));
            if(x < 7)moves.add( coord.offset(1,-1 ));
            if(x > 0)moves.add( coord.offset(-1,- 1));
        }
        else{  //BLACK
            if(y < 7)moves.add( coord.offset(0,1) );
            if(y == 1)moves.add( coord.offset(0,2) );
            if(x < 7)moves.add( coord.offset(1,1) );
            if(x > 0)moves.add( coord.offset(-1,1 ));
        }
        return moves.toArray(new Coordinates[moves.size()]);
    }
}
