package model;

import in_game.Game;

import java.util.ArrayList;

public class Bilche {

    public void action(Game game, int x, int y){
        for (Plant plant : game.getPlants()){
            if (plant.getCell().getX() == x){
                if (plant.getCell().getY() == y){
                    plant.setX(-1);
                    plant.setY(-1);
                    return;
                }
            }
        }
    }

}
