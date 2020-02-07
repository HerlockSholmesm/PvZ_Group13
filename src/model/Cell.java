package model;

public class Cell {
    private boolean dryness;
    private boolean aqua;
    private int x;
    private int y;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isDryness() {
        return dryness;
    }

    public void setDryness(boolean dryness) {
        this.dryness = dryness;
    }

    public boolean isAqua() {
        return aqua;
    }

    public void setAqua(boolean aqua) {
        this.aqua = aqua;
    }


}
