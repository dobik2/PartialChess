import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

public class ChessBoard {
    private ChessPiece[][] board = new ChessPiece[8][8];
    private List<ChessPiece> white = new ArrayList<>();
    private List<ChessPiece> black = new ArrayList<>();

    private Optional<ChessPiece> getPieceOpt(Coordinates coord){
        return Optional.ofNullable(getPieceAtCoords(coord));
    }

    private Optional<ChessPiece> getPieceOpt(String coord){
        ChessPiece piece = getPieceAtCoords(coord);
        return Optional.ofNullable(piece);
    }

    public ChessPiece getPieceAtCoords(Coordinates coord) {
        return board[coord.getX()][coord.getY()];
    }

    public ChessPiece getPieceAtCoords(String coord) {
        Coordinates coordinates = new Coordinates(coord);
        return getPieceAtCoords(coordinates);
    }

    public void add(ChessPiece piece, String coord) {
        piece.coord = new Coordinates(coord);
        board[piece.coord.getX()][piece.coord.getY()] = piece;

    }

    public void move(ChessPiece chessPiece, String coord) {
        Coordinates targetCoord = new Coordinates(coord);
        Optional<ChessPiece> targetPiece = getPieceOpt(coord);
        Coordinates[] validMoves = chessPiece.getValidMoves();

        if (Arrays.asList(validMoves).contains(targetCoord) && !isPlaceOccupiedByFriend(targetCoord, chessPiece.color)) {
            board[chessPiece.coord.getX()][chessPiece.coord.getY()] = null;  // set old place to empty
            if (targetPiece.isPresent()  ) { // there is an enemy
                targetPiece.get().setCoordinates(null);
                if(targetPiece.get().color == ChessPiece.Color.WHITE)black.add(targetPiece.get());
                else white.add(targetPiece.get());
            }
            board[targetCoord.getX()][targetCoord.getY()] = chessPiece;
            chessPiece.setCoordinates(targetCoord);
        }
    }

    private boolean isPlaceOccupiedByFriend(Coordinates coordPlace, ChessPiece.Color color) {
        Optional<ChessPiece> place = getPieceOpt(coordPlace);
        if (place.isPresent() && place.get().color == color) return true;
        return false;
    }

    public ChessPiece[] getWhiteCapturedPieces() {//        return moves.toArray(new Coordinates[moves.size()])
        return white.toArray(new ChessPiece[white.size()]);
    }
    public ChessPiece[] getBlackCapturedPieces() {//        return moves.toArray(new Coordinates[moves.size()])
        return black.toArray(new ChessPiece[black.size()]);
    }
}
