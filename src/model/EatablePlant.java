package model;

import in_game.Game;
import javafx.scene.image.Image;

public class EatablePlant extends Plant {
    public EatablePlant(String name, int sun, int rest, int life, Image image) {
        super(name, 0, sun, rest, life,image);
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
