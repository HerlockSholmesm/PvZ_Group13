package model;

import in_game.Game;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class EatablePlant extends Plant {
    public EatablePlant(String name, int sun, int rest, int life, Image image) {
        super(name, 0, sun, rest, life, image);
    }

    public void action(Game game) {
        ArrayList<Zombie> zombies = game.getZombies();
        for (Zombie zombie : zombies) {
            if ("Explode-o-nut".equals(zombie.getName())) {
                if (this.getClock() <= game.getTurn() && this.getYCoordinate() == zombie.getY() && this.getXCoordinate() == zombie.getX() - 1) {
                    zombie.setLife(zombie.getLife() - 1);
                }
            }
        }
    }

    @Override
    public Image getCardImage() {
        return new Image("Plants vs Zombies/Explode-o-nut/Explode-o-nutSeedPacket.webp");
    }


}
