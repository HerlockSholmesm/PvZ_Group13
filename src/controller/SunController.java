package controller;
import in_game.GameDay;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.Group;
import model.Cell;
import model.DayYard;
import model.Plant;
import model.ProducerPlant;

/**
 * @author YanhanLyu, Lucy Wu
 * If the star of the sunflower is clicked, the controller will reset the sun of the layer
 */
public class SunController implements EventHandler<MouseEvent> {
    GameDay gameDay;
    Group root;
    Label sun;
    Label sunOriginal;
    DayYard dayYard;
    public SunController(DayYard dayYard,GameDay gameDay, Group root, Label sunOriginal) {
        this.root = root;
        this.gameDay = gameDay;
        this.sunOriginal = sunOriginal;
        this.dayYard = dayYard;
    }

    @Override
    public void handle(MouseEvent event) {
        Cell cell = DayYard.whichCellAmI(dayYard, event.getX(), event.getY());
        int row ;
        int column ;
        if (cell!= null){
            column = DayYard.whichCoordinateAmI(dayYard, event.getX(), event.getY())[0];
            row = DayYard.whichCoordinateAmI(dayYard, event.getX(), event.getY())[1];

            for (Plant plant : this.gameDay.getPlants()) {
                if ("Sunflower".equals(plant.getName())) {
                    if (row == plant.getXCoordinate() && column == plant.getYCoordinate()) {
                        ProducerPlant producerPlant = (ProducerPlant) plant;
                        if (producerPlant.isHasStar()){
                            producerPlant.removeStar();
                            this.gameDay.addSuns(1);
                            sunOriginal.setText(String.valueOf(gameDay.getSuns()));

                        }

                    }

                }

            }
            for(Cell[] cellRow:dayYard.getCells()){
                for(Cell cellP:cellRow){
                    if (cellP.isHasImage()){
                        cellP.removeImage();
                        this.gameDay.addSuns(1);
                        sunOriginal.setText(String.valueOf(gameDay.getSuns()));
                    }
                }


        }

}
    }
}





