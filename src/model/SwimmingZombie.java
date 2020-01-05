package model;

import in_game.Game;

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

    }

    public SwimmingZombie(String name, int life, int speed, int defense) {
        super(life, speed, defense, name);
    }
}
