package model;

import in_game.Game;

public class GiantZombie extends Zombie {
    public GiantZombie(String name, int life, int speed, int defense) {
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
        String name = this.getName();
        for (Plant plant : game.getPlants()) {
            if ("Giga-gargantuar".equals(name)) {
                if (this.getX() == plant.getXCoordinate()+1 && this.getY() == plant.getYCoordinate()) {
                    plant.setLife(0);
                    return;
                }else {
                    move();
                }
            }
        }
    }
}
