package model;

import in_game.Game;
import javafx.scene.image.Image;

public class SwimmingZombie extends Zombie {
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
        String name = this.getName();
        for (Plant plant : game.getPlants()) {
            switch (name) {
                case ("Snorkel Zombie"):
                    if (this.getX() == plant.getXCoordinate() && this.getY() == plant.getYCoordinate()) {
                        plant.setLife(plant.getLife() - 1);
                    } else {
                        move();
                    }
                case ("Dolphin Rider Zombie"):
                    if (this.getX() == plant.getXCoordinate() && this.getY() == plant.getYCoordinate()) {
                        plant.setLife(plant.getLife() - 1);
                    } else {
                        move();
                    }
            }
        }
    }

    public SwimmingZombie(String name, int life, int speed, int defense, Image image ) {
        super(life, speed, defense, name, image);
    }
}
