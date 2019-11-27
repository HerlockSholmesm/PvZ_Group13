public class Yard {
    private Cell yard [][]=new Cell[6][19];
    private boolean isItPerson1Tern;
    private boolean isItPerson2Tern;
    private boolean isItPerson1Win;
    private boolean isItPerson2Win;

    public void setYard(Cell[][] yard) {
        this.yard = yard;
    }

    public void setItPerson1Tern(boolean itPerson1Tern) {
        isItPerson1Tern = itPerson1Tern;
    }

    public void setItPerson2Tern(boolean itPerson2Tern) {
        isItPerson2Tern = itPerson2Tern;
    }

    public void setItPerson1Win(boolean itPerson1Win) {
        isItPerson1Win = itPerson1Win;
    }

    public void setItPerson2Win(boolean itPerson2Win) {
        isItPerson2Win = itPerson2Win;
    }

    public Cell[][] getYard() {
        return yard;
    }

    public boolean isItPerson1Tern() {
        return isItPerson1Tern;
    }

    public boolean isItPerson2Tern() {
        return isItPerson2Tern;
    }

    public boolean isItPerson1Win() {
        return isItPerson1Win;
    }

    public boolean isItPerson2Win() {
        return isItPerson2Win;
    }
}
