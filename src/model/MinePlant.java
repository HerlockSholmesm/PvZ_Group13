package model;

import in_game.Game;

class MinePlant extends Plant {
    public MinePlant(String name, int cells, int sun, int rest, int life) {

        super(name, 0, sun, rest, life);
    }

    @Override
    public void action(Game game) {
        String name = this.getName();
        for (Zombie zombie : game.getZombies()) {
            switch (name) {
                case ("Potato Mine"):
                    if (this.getXCoordinate() == zombie.getX() && this.getYCoordinate() == zombie.getY()) {
                        zombie.setX(-1);
                        zombie.setY(-1);
                    }
                case ("Cherry Bomb"):
                    if (this.getXCoordinate() == zombie.getX() && this.getYCoordinate() == zombie.getY()) {
                        zombie.setX(-1);
                        zombie.setY(-1);
                    }
                case ("Magnet-shroom"):
                    if (this.getXCoordinate() == zombie.getX() && this.getYCoordinate() == zombie.getY()) {
                        zombie.setX(-1);
                        zombie.setY(-1);
                    }
                case ("Jalapeno"):
                    if (this.getXCoordinate() == zombie.getX() && this.getYCoordinate() == zombie.getY()) {
                        zombie.setX(-1);
                        zombie.setY(-1);
                    }
            }

        }
    }
}
