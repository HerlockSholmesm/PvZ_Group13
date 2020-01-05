package model;

import in_game.Game;

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
                    }
                case ("Football Zombie"):
                    if (this.getX() == plant.getXCoordinate() && this.getY() == plant.getYCoordinate()) {
                        plant.setLife(plant.getLife() - 1);
                    }
                case ("BucketHead Zombie"):
                    if (this.getX() == plant.getXCoordinate() && this.getY() == plant.getYCoordinate()) {
                        plant.setLife(plant.getLife() - 1);
                    }
                case ("ConeHead Zombie"):
                    if (this.getX() == plant.getXCoordinate() && this.getY() == plant.getYCoordinate()) {
                        plant.setLife(plant.getLife() - 1);
                    }
                case ("Zomboni"):
                    if (this.getX() == plant.getXCoordinate() && this.getY() == plant.getYCoordinate()) {
                        plant.setLife(plant.getLife() - 1);
                    }
                case ("Catapult Zombie"):
                    if (this.getX() == plant.getXCoordinate() && this.getY() == plant.getYCoordinate()) {
                        plant.setLife(plant.getLife() - 1);
                    }
                case ("Bungee Zombie"):
                    if (this.getX() == plant.getXCoordinate() && this.getY() == plant.getYCoordinate()) {
                        plant.setLife(plant.getLife() - 1);
                    }
                case ("Balloon Zombie"):
                    if (this.getX() == plant.getXCoordinate() && this.getY() == plant.getYCoordinate()) {
                        plant.setLife(plant.getLife() - 1);
                    }


            }
        }
    }

    public MovingZombie(String name, int life, int speed, int defense) {
        super(life, speed, defense, name);
    }
}
