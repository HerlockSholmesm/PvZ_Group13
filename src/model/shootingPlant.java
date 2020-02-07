package model;

import in_game.Game;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class shootingPlant extends Plant {
    public shootingPlant(String name, int clock, int numberOfPea, int sun, int rest, int life, Image image) {
        super(name, clock, sun, rest, life,image);
    }

    public void shoot(int number, int x, int y) {
        ArrayList<PeaBullet> peaBullets = null;
        for (int i = 0; i < number; i++) {
            peaBullets.add(new PeaBullet(x, y));
        }
    }

    @Override
    public void action(Game game) {
        String name = this.getName();
        for (Zombie zombie : game.getZombies()) {
            if (!zombie.equals("Balloon Zombie")) {
                switch (name) {
                    case ("Peashooter"):
                        if (game.getTurn() >= this.getClock()) {
                            if (this.getYCoordinate() == zombie.getY()) {
                                game.setPeaBullets(this.getXCoordinate(), this.getYCoordinate(), game);
                            }
                        }
                    case ("Snow Pea"):
                        if (game.getTurn() >= this.getClock()) {
                            if (this.getYCoordinate() == zombie.getY()) {
                                game.setPeaBullets(this.getXCoordinate(), this.getYCoordinate(), game);
                                zombie.setSpeed(zombie.getSpeed() / 2);
                            }
                        }

                    case ("Repeater"):
                        if (game.getTurn() >= this.getClock()) {
                            if (this.getYCoordinate() == zombie.getY()) {
                                for (int i = 0; i < 2; i++) {
                                    game.setPeaBullets(this.getXCoordinate(), this.getYCoordinate(), game);

                                }
                            }
                        }
                    case ("Threepeater"):
                        if (game.getTurn() >= this.getClock()) {
                            if (this.getYCoordinate() == zombie.getY()) {
                                game.setPeaBullets(this.getXCoordinate(), this.getYCoordinate(), game);
                                game.setPeaBullets(this.getXCoordinate(), this.getYCoordinate() + 1, game);
                                game.setPeaBullets(this.getXCoordinate(), this.getYCoordinate() - 1, game);
                            }
                        }
                    case ("Cactus"):
                        if (game.getTurn() >= this.getClock()) {
                            if (this.getYCoordinate() == zombie.getY()) {
                                game.setPeaBullets(this.getXCoordinate(), this.getYCoordinate(), game);
                                if (this.getXCoordinate() == zombie.getX()-1) {
                                    if (!zombie.getName().equals("Football Zombie"))
                                        zombie.setLife(zombie.getLife() - 1);
                                }
                            }
                        }
                    case ("Gatling Pea"):
                        if (game.getTurn() >= this.getClock()) {
                            if (this.getYCoordinate() == zombie.getY()) {
                                for (int i = 0; i < 5; i++) {
                                    game.setPeaBullets(this.getXCoordinate(), this.getYCoordinate(), game);
                                }
                            }
                        }
                    case ("Scaredy-shroom"):
                        if (game.getTurn() >= this.getClock()) {
                            if (this.getYCoordinate() == zombie.getY()) {
                                if (this.getXCoordinate() - zombie.getX() >= 2)
                                    game.setPeaBullets(this.getXCoordinate(), this.getYCoordinate(), game);
                            }
                        }
                    case ("Split Pea"):
                        if (game.getTurn() >= this.getClock()) {
                            if (this.getYCoordinate() == zombie.getY()) {
                                game.setPeaBullets(this.getXCoordinate(), this.getYCoordinate(), game);
                                game.setPeaBulletsNegetive(this.getXCoordinate(), this.getYCoordinate(), game);
                            }
                        }
                }
            }

        }
    }
}

