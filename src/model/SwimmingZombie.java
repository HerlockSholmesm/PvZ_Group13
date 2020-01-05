package model;

public class SwimmingZombie extends Zombie {
    @Override
    public void attack(Card card) {
        super.attack(card);
    }

    @Override
    public void beAttacked(Card card) {
        super.beAttacked(card);
    }

    @Override
    public void move() {
        super.move();
    }

    public SwimmingZombie(String name, int life, int speed, int defense) {
        super(life, speed, defense, name);
    }
}
