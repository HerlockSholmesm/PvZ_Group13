package model;

import in_game.Game;

class throwingPlant extends Plant {

    public throwingPlant(String name, int clock, int numberOfBullet, int power, int sun, int rest, int life) {
        super(name, clock, sun, rest, life);
    }

    @Override
    public void action(Game game) {
        String name = this.getName();
        for (Zombie zombie : game.getZombies()) {
            switch (name) {
                case ("Cabbage-pult"):
                    if (game.getTurn() >= this.getClock()) {
                        if (this.getYCoordinate() == zombie.getY()) {
                            game.setThrowingThings(this.getXCoordinate(), this.getYCoordinate(), 2, game);
                        }
                    }
                case ("Kernel-pult"):
                    if (game.getTurn() >= this.getClock()) {
                        if (this.getYCoordinate() == zombie.getY()) {
                            game.setThrowingThings(this.getXCoordinate(), this.getYCoordinate(), 0, game);
                            //todo lock zombie
                        }
                    }
                case ("Melon-pult"):
                    if (game.getTurn() >= this.getClock()) {
                        if (this.getYCoordinate() == zombie.getY()) {
                            game.setThrowingThings(this.getXCoordinate(), this.getYCoordinate(), 3, game);
                        }
                    }
                case ("Winter Melon"):
                    if (game.getTurn() >= this.getClock()) {
                        if (this.getYCoordinate() == zombie.getY()) {
                            game.setThrowingThings(this.getXCoordinate(), this.getYCoordinate(), 3, game);
                            zombie.setSpeed(zombie.getSpeed() / 2);
                            //todo for one turn
                        }
                    }

            }
        }
    }
}
