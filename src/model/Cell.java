package model;

public class Cell {
    private boolean dryness;
    private boolean aqua;
    private int x1;
    private int x2;
    private int y1;
    private int y2;

    public Cell(boolean dryness, boolean aqua, int x1, int x2, int y1, int y2) {
        this.dryness = dryness;
        this.aqua = aqua;
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }

    public int getY1() {
        return y1;
    }

    public int getY2() {
        return y2;
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
