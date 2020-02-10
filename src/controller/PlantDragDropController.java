package controller;

import in_game.GameDay;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.DragEvent;
import javafx.scene.layout.StackPane;
import model.*;

/**
 *@author YanhanLyu, Lucy Wu
 * Class that controls the behavior of dropping dragged plants
 */
public class PlantDragDropController implements EventHandler<DragEvent> {
    Group root;
    GameDay gameDay;
    DayYard dayYard;
    //private Sun sun;

    public PlantDragDropController(Group root, GameDay gameDay,DayYard dayYard){
        this.root = root;
        this.gameDay = gameDay;
        this.dayYard = dayYard;
    }
    @Override
    public void handle(DragEvent event) {

        Cell cell = DayYard.whichCellAmI(dayYard, event.getX(), event.getY());
        System.out.println("Hi 29");
        int row ;
        int column ;
        if (cell!= null) {
            column = DayYard.whichCoordinateAmI(dayYard, event.getX(), event.getY())[0];
            row = DayYard.whichCoordinateAmI(dayYard, event.getX(), event.getY())[1];

            boolean add = true;
            for (Plant plant:gameDay.getPlants()){
                if (plant.getXCoordinate() == column && plant.getYCoordinate() == row) {
                    add = false;
                    System.out.println("is it false p");
                    break;
                }
            }
            if(add){
                for(Zombie zombie:gameDay.getZombies()){
                    if (zombie.getX() == column && zombie.getY() == row) {
                        add = false;
                        System.out.println("is it false p");
                        break;
                    }
                }
                if(add){
                    String Name = event.getDragboard().getString();
                    for(Card card:gameDay.getCards()){
                        if (Name.equals(card.getName())){
                            System.out.println("Name is " + Name);
                            System.out.println("Name of found is  " + card.getName());
                            Plant tempPlant = (Plant) card;
                            if(gameDay.getSuns() >= tempPlant.getSun()){
                                System.out.println("in if ");
                                //int x = DayYard.whichCoordinateAmI(dayYard,row,column)[0];
                                //int y = DayYard.whichCoordinateAmI(dayYard,row,column)[1];
                                int pixelX = dayYard.whichPixelAmI(cell)[0];
                                System.out.println(pixelX + " pixel x");
                                int pixelY = dayYard.whichPixelAmI(cell)[1];
                                System.out.println(pixelY + "pixel y");
                                if(tempPlant instanceof EatablePlant){
                                    Plant plant = new EatablePlant(tempPlant.getName(),tempPlant.getSun()
                                            ,tempPlant.getRest(),tempPlant.getLife(),tempPlant.getImage());
                                    gameDay.addPlant(plant);
                                    gameDay.setSun(gameDay.getSuns() - plant.getSun());
                                    plant.setX(pixelX);
                                    plant.setY(pixelY);
                                    System.out.println("I'm in E");
                                }
                                else if (tempPlant instanceof MinePlant){
                                    Plant plant = new MinePlant(tempPlant.getName(),tempPlant.getClock()
                                            ,tempPlant.getSun(),tempPlant.getRest(),tempPlant.getLife(),tempPlant.getImage());
                                    gameDay.addPlant(plant);
                                    plant.setX(pixelX);
                                    plant.setY(pixelY);
                                    System.out.println("I'm in M");
                                }
                                else if (tempPlant instanceof ProducerPlant){
                                    Plant plant = new ProducerPlant(tempPlant.getName(),tempPlant.getClock()
                                            ,0,tempPlant.getSun(),tempPlant.getRest(),tempPlant.getLife(),tempPlant.getImage(),root);
                                    gameDay.addPlant(plant);
                                    plant.setX(pixelX);
                                    plant.setY(pixelY);
                                    System.out.println("I'm in P");
                                }
                                else if (tempPlant instanceof shootingPlant){
                                    Plant plant = new shootingPlant(tempPlant.getName(),tempPlant.getClock()
                                            ,0,tempPlant.getSun(),tempPlant.getRest(),tempPlant.getLife(),tempPlant.getImage());
                                    gameDay.addPlant(plant);
                                    plant.setX(pixelX);
                                    plant.setY(pixelY);
                                    System.out.println("I'm in s");

                                }
                                else if (tempPlant instanceof throwingPlant){
                                    Plant plant = new throwingPlant(tempPlant.getName(),tempPlant.getClock()
                                            ,0,0 ,tempPlant.getSun(),tempPlant.getRest(),tempPlant.getLife(),tempPlant.getImage());
                                    gameDay.addPlant(plant);
                                    plant.setX(pixelX);
                                    plant.setY(pixelY);
                                    System.out.println("I'm in t");

                                }
                                else{
                                    Plant plant = new ToPlantOnPlant(tempPlant.getName()
                                            ,tempPlant.getSun(),tempPlant.getRest(),tempPlant.getLife(),tempPlant.getImage());
                                    gameDay.addPlant(plant);
                                    plant.setX(pixelX);
                                    plant.setY(pixelY);
                                    System.out.println("I'm in Else");

                                }

                            }
                        }
                    }
                }
            }

        }

    }

}

