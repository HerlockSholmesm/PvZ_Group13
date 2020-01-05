package model;

import in_game.Game;

public class FlyingZombie extends Zombie {
    public FlyingZombie(String name, int life, int speed, int defense) {
        super(life, speed, defense, name);
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

    }
}
