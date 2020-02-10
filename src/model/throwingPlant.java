package model;

import in_game.Game;
import javafx.scene.image.Image;

public class throwingPlant extends Plant {

    public throwingPlant(String name, int clock, int numberOfBullet, int power, int sun, int rest, int life, Image image) {
        super(name, clock, sun, rest, life, image);
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
                            zombie.setCanmove(2);
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
                        }
                    }

            }
        }
    }

    @Override
    public Image getCardImage() {
        String name = this.getName();
        switch (name) {
            case ("Cabbage-pult"):
                return new Image("Plants vs Zombies/Cabbage-pult/Cabbage_Pult_Seed.webp");
            case ("Kernel-pult"):
                return new Image("Plants vs Zombies/Kernel-pult/Kernel-Pult_Seed.webp");
            case ("Melon-pult"):
                return new Image("Plants vs Zombies/Melon-pult/Melon_Pult_Seed.webp");
            case ("Winter Melon"):
                return new Image("Plants vs Zombies/Winter Melon/Winter_HD.webp");
            default:
                return null;

        }
    }
}
