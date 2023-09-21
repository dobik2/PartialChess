import java.util.Objects;

public class Coordinates {
    private int x;
    private int y;
    private String chessCoord;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Coordinates(String chessCoord) {
        this.chessCoord = chessCoord;
        x = 8 - Integer.parseInt(chessCoord.substring(1));
        y = chessCoord.charAt(0) - 97;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return x == that.x && y == that.y && chessCoord.equals(that.chessCoord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, chessCoord);
    }

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
        chessCoord = (char)(y + 97) + String.valueOf(8-x);
    }
}
