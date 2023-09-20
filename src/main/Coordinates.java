public class Coordinates {
    private int x;
    private int y;
    private String chessCord;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Coordinates(String chessCord) {
        this.chessCord = chessCord;
        x = 8 - Integer.parseInt(chessCord.substring(1));
        y = chessCord.charAt(0) - 97;
    }
}
