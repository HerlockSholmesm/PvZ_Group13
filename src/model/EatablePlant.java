package model;

import in_game.Game;

public class EatablePlant extends Plant {
    public EatablePlant(String name, int sun, int rest, int life) {
        super(name, 0, sun, rest, life);
    }

    @Override
    public void action(Game game) {
        String name = this.getName();
        for (Zombie zombie : game.getZombies()) {
            switch (name) {
                case ("Explode-o-nut"):
                    if (this.getXCoordinate() == zombie.getX()) {
                        this.setLife(this.getLife() - 1);
                        //todo stop zombie
                    }
                case ("Wall-nut"):
                    if (this.getXCoordinate() == zombie.getX()) {
                        this.setLife(this.getLife() - 1);
                    }
                case ("Tangle Kelp"):
                    if (this.getXCoordinate() == zombie.getX()) {
                        this.setLife(this.getLife() - 1);
                    }
                case ("Tall-nut"):
                    if (this.getXCoordinate() == zombie.getX()) {
                        this.setLife(this.getLife() - 1);
                    }
                case ("Cattail"):
                    if (this.getXCoordinate() == zombie.getX()) {
                        this.setLife(this.getLife() - 1);
                    }
            }

        }
    }


}
