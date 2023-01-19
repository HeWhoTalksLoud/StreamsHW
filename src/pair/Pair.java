package pair;

public class Pair {
    private Integer X;
    private Integer Y;

    public Integer getX() {
        return X;
    }

    public void setX(Integer x) {
        X = x;
    }

    public Integer getY() {
        return Y;
    }

    public void setY(Integer y) {
        Y = y;
    }

    public Pair(Integer x, Integer y) {
        X = x;
        Y = y;
    }

    @Override
    public String toString() {
        return "X=" + X + ", Y=" + Y;
    }
}
