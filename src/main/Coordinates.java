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
        x = chessCoord.charAt(0) - 97;
        y = 8 - Integer.parseInt(chessCoord.substring(1));
    }

    public Coordinates offset(int x, int y){
        this.x += x;
        this.y += y;
        chessCoord = (char)(this.x + 97) + String.valueOf(8-this.y);
        return this;
    }

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
        chessCoord = (char)(x + 97) + String.valueOf(8-y);
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                ", chessCoord='" + chessCoord + '\'' +
                '}';
    }

    public String getChessCoord() {
        return chessCoord;
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
}
