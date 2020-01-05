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

    }
}
