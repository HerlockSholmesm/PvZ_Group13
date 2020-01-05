package model;

import in_game.Game;

class ShieldZombie extends Zombie {

    int life;

    public ShieldZombie(String name, int life, int speed, int defense) {
        super(life, speed, defense, name);
    }

    public void addLife(int addNumber) {
        this.life = +addNumber;
    }

    @Override
    public void action(Game game) {
        String name = this.getName();
        for (Plant plant : game.getPlants()) {
            switch (name) {
                case ("Newspaper Zombie"):
                    if (this.getX() == plant.getXCoordinate() && this.getY() == plant.getYCoordinate()) {
                        plant.setLife(plant.getLife() - 1);
                    }
                case ("Target Zombie"):
                    if (this.getX() == plant.getXCoordinate() && this.getY() == plant.getYCoordinate()) {
                        plant.setLife(plant.getLife() - 1);
                    }
                case ("Screen Door Zombie"):
                    if (this.getX() == plant.getXCoordinate() && this.getY() == plant.getYCoordinate()) {
                        plant.setLife(plant.getLife() - 1);
                    }
            }
        }
    }
}
