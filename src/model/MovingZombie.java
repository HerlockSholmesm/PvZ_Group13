package model;

import in_game.Game;

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
                        move();
                    }
                case ("Football Zombie"):
                    if (this.getX() == plant.getXCoordinate() && this.getY() == plant.getYCoordinate()) {
                        plant.setLife(plant.getLife() - 1);
                    }else {
                        move();
                    }
                case ("BucketHead Zombie"):
                    if (this.getX() == plant.getXCoordinate() && this.getY() == plant.getYCoordinate()) {
                        plant.setLife(plant.getLife() - 1);
                    }else {
                        move();
                    }
                case ("ConeHead Zombie"):
                    if (this.getX() == plant.getXCoordinate() && this.getY() == plant.getYCoordinate()) {
                        plant.setLife(plant.getLife() - 1);
                    }else {
                        move();
                    }
                case ("Zomboni"):
                    if ( this.getY() == plant.getYCoordinate()) {
                        plant.setX(-1);
                        plant.setY(-1);
                    }else {
                        move();
                    }
                case ("Catapult Zombie"):
                    if ( this.getY() == plant.getYCoordinate()) {
                        plant.setX(-1);
                        plant.setY(-1);
                    }else {
                        move();
                    }
                case ("Bungee Zombie"):
                    if (this.getX() == plant.getXCoordinate() && this.getY() == plant.getYCoordinate()) {
                        plant.setX(-1);
                        plant.setY(-1);
                        //todo random appeare
                    }else {
                        move();
                    }
                case ("Balloon Zombie"):
                    if (this.getX() == plant.getXCoordinate() && this.getY() == plant.getYCoordinate()) {
                        plant.setLife(plant.getLife() - 1);
                    }else {
                        move();
                    }

            }
        }
    }

    public MovingZombie(String name, int life, int speed, int defense) {
        super(life, speed, defense, name);
    }
}
