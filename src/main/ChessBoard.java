public class ChessBoard {
    private ChessPiece[][] board = new ChessPiece[8][8];


    public void add(ChessPiece piece, String coord) {
        piece.coord = new Coordinates(coord);
        board[piece.coord.getX()][piece.coord.getY()] = piece;

    }

    public ChessPiece getPieceAtCoords(String coord) {
        Coordinates coordinates = new Coordinates(coord);
        return board[coordinates.getX()][coordinates.getY()];
    }
}
