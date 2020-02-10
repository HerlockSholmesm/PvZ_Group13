package model;

import in_game.Game;
import in_game.GameDay;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class GiantZombie extends Zombie {
    public GiantZombie(String name, int life, int speed, int defense, Image image) {
        super(life, speed, defense, name,image);
    }

    @Override
    public void attack(Card card) {
        super.attack(card);
    }


    @Override
    public void move() {
        super.move();
    }

    @Override
    public void action(Game game) {
        ArrayList<Plant> plants = game.getPlants();
        for (Plant plant : plants) {
            if ("Giga-gargantuar".equals(plant.getName())) {
                if (this.getX() == plant.getXCoordinate(new DayYard((GameDay)game))+1 && this.getY(new DayYard((GameDay)game)) == plant.getYCoordinate(new DayYard((GameDay)game))) {
                    plant.setLife(0);
                }
                move();
            }
        }
    }
}
