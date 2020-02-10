package model;

import in_game.Game;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class Bilche {
    private Image image ;

    public Image getImage() {
        return image;
    }

    public void action(Game game, int x, int y){
        for (Plant plant : game.getPlants()){
            if (plant.getCell().getX1() == x){
                if (plant.getCell().getY1() == y){
                    plant.setX(-1);
                    plant.setY(-1);
                    return;
                }
            }
        }
    }

}
