package model;

import in_game.Game;

class ShieldZombie extends Zombie {

    int life;

    public ShieldZombie(int life, int speed, int defense, String name) {
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
                case ("zombie"):
                    if (this.getX() == plant.getXCoordinate() && this.getY() == plant.getYCoordinate()) {
                        plant.setLife(plant.getLife() - 1);
                    }
            }
        }
    }
}
