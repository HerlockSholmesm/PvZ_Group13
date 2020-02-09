package model;

import in_game.Game;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class FlyingZombie extends Zombie {
    public FlyingZombie(String name, int life, int speed, int defense, Image image) {
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
            if ("Pogo Zombie".equals(plant.getName())) {
                if (this.getX() == plant.getXCoordinate() + 1 && this.getY() == plant.getYCoordinate()) {
                    this.setX(plant.getXCoordinate() - 1);
                } else {
                    move();
                }
            }
        }
    }
}
