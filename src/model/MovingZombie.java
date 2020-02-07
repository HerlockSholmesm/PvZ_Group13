package model;

import in_game.Game;
import javafx.scene.image.Image;

import javax.swing.*;

public class MovingZombie extends Zombie {
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
                case ("zombie"):
                    if (this.getX() == plant.getXCoordinate() && this.getY() == plant.getYCoordinate()) {
                        plant.setLife(plant.getLife() - 1);
                    }else {
                        if(plant.getLife()==0)
                        move();
                    }
                case ("Football Zombie"):
                    if (this.getX() == plant.getXCoordinate() && this.getY() == plant.getYCoordinate()) {
                        plant.setLife(plant.getLife() - 1);
                    }else {
                        if(plant.getLife()==0)
                        move();
                    }
                case ("BucketHead Zombie"):
                    if (this.getX() == plant.getXCoordinate() && this.getY() == plant.getYCoordinate()) {
                        plant.setLife(plant.getLife() - 1);
                    }else {
                        if(plant.getLife()==0)
                        move();
                    }
                case ("ConeHead Zombie"):
                    if (this.getX() == plant.getXCoordinate() && this.getY() == plant.getYCoordinate()) {
                        plant.setLife(plant.getLife() - 1);
                    }else {
                        if(plant.getLife()==0)
                        move();
                    }
                case ("Zomboni"):
                    if ( this.getY() == plant.getYCoordinate()) {
                      plant.setLife(0);
                    }else {
                        if(plant.getLife()==0)
                        move();
                    }
                case ("Catapult Zombie"):
                    if ( this.getY() == plant.getYCoordinate()) {
                        plant.setLife(0);
                    }else {
                        if(plant.getLife()==0)
                        move();
                    }
                case ("Bungee Zombie"):
                 game.getPlants().get((int) (Math.random()/7)).setLife(0);

            }
        }
    }

    public MovingZombie(String name, int life, int speed, int defense, Image image ) {
        super(life, speed, defense, name,image);
    }
}
