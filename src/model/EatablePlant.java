package model;

import in_game.Game;

public class EatablePlant extends Plant {
    public EatablePlant(String name, int sun, int rest, int life) {
        super(name, 0, sun, rest, life);
    }

    public void action(Game game) {
        String name = this.getName();
        for (Zombie zombie : game.getZombies()) {
            switch (name) {
                case ("Explode-o-nut"):
                    if (this.getYCoordinate() == zombie.getY() && this.getXCoordinate() == zombie.getX()-1) {
                      zombie.setLife(zombie.getLife()-1);
                    }
            }
        }
    }


}
