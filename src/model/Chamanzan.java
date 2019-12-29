package model;

public class Chamanzan {

    boolean isAvailable;
    private Cell whichRow;
    private Cell waterYard[][] = new Cell[2][19];
    private Yard yard;

    public Chamanzan(Cell whichCell, Yard yard) {
        this.whichRow = whichCell;
        this.yard = yard;
    }

    public void setWaterYard(Cell[][] waterYard) {
        this.waterYard = waterYard;
    }

    public Chamanzan(Cell whichCell) {
        this.isAvailable = true;
        this.whichRow = whichCell;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Cell getWhichCell() {
        return whichRow;
    }

    public void setWhichCell(Cell whichCell) {
        this.whichRow = whichCell;
    }


    public void use() {

    }

}
