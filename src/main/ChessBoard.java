import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ChessBoard {
    private ChessPiece[][] board = new ChessPiece[8][8];
    private List<ChessPiece> white = new ArrayList<>();
    private List<ChessPiece> black = new ArrayList<>();

    private Optional<ChessPiece> getPieceOpt(Coordinates coord) {
        return Optional.ofNullable(getPieceAtCoords(coord));
    }

    private Optional<ChessPiece> getPieceOpt(String coord) {
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

    public void remove(ChessPiece piece) {
        board[piece.coord.getX()][piece.coord.getY()] = null;
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
            remove(chessPiece); // set old field to empty
            if (targetPiece.isPresent()) { // there is an enemy
                targetPiece.get().setCoordinates(null); // set enemy's coordinates to null
                if (targetPiece.get().color == ChessPiece.Color.WHITE)
                    black.add(targetPiece.get());  // add enemy to list of removed chess pieces
                else white.add(targetPiece.get());
            }
            add(chessPiece, coord);
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
