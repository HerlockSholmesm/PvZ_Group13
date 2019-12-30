package model;
public class Bilche {
    private Cell whichCell;
    private model.Yard yard;

    public Bilche(Cell whichCell,Yard yard) {
        this.whichCell = whichCell;
        this.yard=yard;
    }

    public void use(Cell cell2){
        for (Plant plant :Shop.getAllPlants()) {
            if(plant.getCell()==cell2){
                plant.setX(-1);
                plant.setY(-1);
            }
        }
    }

    public static class Control {


    }
}
