package model;

import in_game.Game;
import in_game.GameDay;
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
                if (this.getX(game.getYard()) == plant.getXCoordinate(game.getYard()) + 1 && this.getY(game.getYard()) == plant.getYCoordinate(game.getYard())) {
                    this.setX(- 1, new DayYard((GameDay)game));
                } else {
                    move(new DayYard((GameDay)game));
                }
            }
            else if ("Balloon Zombie".equals(plant.getName())){

            }
        }
    }
}
