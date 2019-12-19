public class Chamanzan {

    boolean isAvailable;
    Cell whichCell;

    public Chamanzan(Cell whichCell) {
        this.isAvailable = true;
        this.whichCell = whichCell;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Cell getWhichCell() {
        return whichCell;
    }

    public void setWhichCell(Cell whichCell) {
        this.whichCell = whichCell;
    }


    public void use(){

    }

}
