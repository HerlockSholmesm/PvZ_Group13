package model;

import in_game.Game;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class shootingPlant extends Plant {
    ArrayList<PeaBullet> peaBullets = new ArrayList<>();
    public shootingPlant(String name, int clock, int numberOfPea, int sun, int rest, int life, Image image) {
        super(name, clock, sun, rest, life,image);
    }

    public void shoot(int number, int x, int y) {
        for (int i = 0; i < number; i++) {
            peaBullets.add(new PeaBullet(x, y));
        }
    }

    public ArrayList<PeaBullet> getPeaBullets() {
        return peaBullets;
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

    @Override
    public Image getCardImage() {
        String name = this.getName();
        switch (name) {
            case ("Peashooter"):
                return new Image("Plants vs Zombies/Peashooter/Peashooter_HD_Seed.webp");
            case ("Snow Pea"):
                return new Image("Plants vs Zombies/Snow Pea/Snow_Pea_HD_Seed.webp");
            case ("Repeater"):
                return new Image("Plants vs Zombies/Repeater/Repeater_Seed.webp");
            case ("Threepeater"):
                return new Image("Plants vs Zombies/Threepeater/1769829-plant_peashooter_thumb.webp");
            case ("Cactus"):
                return new Image("Plants vs Zombies/Cactus/Cactus_Seed.webp");
            case ("Gatling Pea"):
                return new Image("Plants vs Zombies/Gatling Pea/Gatling_Pea_Seed.webp");
            case ("Scaredy-shroom"):
                return new Image("Plants vs Zombies/Scared-shroom/Threepeater.webp");
                case ("Split Pea"):
                    return new Image("Plants vs Zombies/Split Pea/ScaredyShroomhide2009HD.webp");
            default:
                return null;
        }
    }
}

