import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChessBoard {
    private ChessPiece[][] board = new ChessPiece[8][8];
    private List<ChessPiece> white = new ArrayList<>();
    private List<ChessPiece> black = new ArrayList<>();


    public void add(ChessPiece piece, String coord) {
        piece.coord = new Coordinates(coord);
        board[piece.coord.getX()][piece.coord.getY()] = piece;

    }

    public ChessPiece getPieceAtCoords(String coord) {
        Coordinates coordinates = new Coordinates(coord);
        return board[coordinates.getX()][coordinates.getY()];
    }

    public void move(ChessPiece chessPiece, String coord) {
        Coordinates targetCoord = new Coordinates(coord);
        ChessPiece targetPiece = board[targetCoord.getX()][targetCoord.getY()];
        Coordinates[] validMoves = chessPiece.getValidMoves();

        if (Arrays.asList(validMoves).contains(targetCoord) && !isPlaceOccupiedByFriend(targetCoord, chessPiece.color)) {
            board[chessPiece.coord.getX()][chessPiece.coord.getY()] = null;
            if (targetPiece != null) { // there is an enemy
                targetPiece.setCoordinates(null);
                if(targetPiece.color == ChessPiece.Color.WHITE)black.add(targetPiece);
                else white.add(targetPiece);
            }
            board[targetCoord.getX()][targetCoord.getY()] = chessPiece;
            chessPiece.setCoordinates(targetCoord);
        }
    }

    private boolean isPlaceOccupiedByFriend(Coordinates coordPlace, ChessPiece.Color color) {
        //Coordinates coordPlace = new Coordinates(coord);
        ChessPiece place = board[coordPlace.getX()][coordPlace.getY()];
        if (place != null && place.color == color) return true;
        return false;
    }

    public ChessPiece[] getWhiteCapturedPieces() {//        return moves.toArray(new Coordinates[moves.size()])
        return white.toArray(new ChessPiece[white.size()]);
    }
    public ChessPiece[] getBlackCapturedPieces() {//        return moves.toArray(new Coordinates[moves.size()])
        return black.toArray(new ChessPiece[black.size()]);
    }
}
