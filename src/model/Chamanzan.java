package model;

public class Chamanzan {

    boolean isAvailable;
    private int whichRow;
    private Cell waterYard[][] = new Cell[2][19];
    private Yard yard;

    public Chamanzan(int whichCell, Yard yard) {
        this.whichRow = whichCell;
        this.yard = yard;
    }

    public void setWaterYard(Cell[][] waterYard) {
        this.waterYard = waterYard;
    }

    public Chamanzan(int whichCell) {
        this.isAvailable = true;
        this.whichRow = whichCell;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getWhichCell() {
        return whichRow;
    }

    public void setWhichCell(int whichCell) {
        this.whichRow = whichCell;
    }


    public void use() {
        for (Zombie zombie:Shop.getZombies()) {
            if(zombie.getY()==whichRow){
                zombie.setX(-1);
                zombie.setY(-1);
            }
        }
    }

}
