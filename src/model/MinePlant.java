package model;

import in_game.Game;
import javafx.scene.image.Image;

public class MinePlant extends Plant {
    public MinePlant(String name, int cells, int sun, int rest, int life, Image image) {

        super(name, 0, sun, rest, life,image );
    }

    @Override
    public void action(Game game) {
        String name = this.getName();
        for (Zombie zombie : game.getZombies()) {
            switch (name) {
                case ("Potato Mine"):
                    if (this.getXCoordinate() == zombie.getX() && this.getYCoordinate() == zombie.getY()) {
                        zombie.setLife(0);
                    }
                case ("Cherry Bomb"): {
                    if ((this.getXCoordinate() == zombie.getX()) && ((this.getYCoordinate() == zombie.getY() + 1)
                            || (this.getYCoordinate() == zombie.getY() - 1))) {
                        zombie.setLife(0);
                    }
                    if ((this.getXCoordinate() == zombie.getX()+1) && ((this.getYCoordinate() == zombie.getY() + 1)
                            || (this.getYCoordinate() == zombie.getY() - 1))) {
                        zombie.setLife(0);
                    }
                    if ((this.getXCoordinate() == zombie.getX()-1) && ((this.getYCoordinate() == zombie.getY() + 1)
                            || (this.getYCoordinate() == zombie.getY() - 1))) {
                        zombie.setLife(0);
                    }
                }
                case ("Magnet-shroom"):{
                    if ((this.getXCoordinate() == zombie.getX()) && ((this.getYCoordinate() == zombie.getY() + 1)
                            || (this.getYCoordinate() == zombie.getY() - 1)||
                            (this.getYCoordinate() == zombie.getY() ))) {
                        zombie.setLife(0);
                    }
                    if ((this.getXCoordinate() == zombie.getX()+1) && ((this.getYCoordinate() == zombie.getY() + 1)
                            || (this.getYCoordinate() == zombie.getY() - 1)||
                            (this.getYCoordinate() == zombie.getY() ))) {
                        zombie.setLife(0);
                    }
                    if ((this.getXCoordinate() == zombie.getX()-1) && ((this.getYCoordinate() == zombie.getY() + 1)
                            || (this.getYCoordinate() == zombie.getY() - 1)||
                            (this.getYCoordinate() == zombie.getY() ))) {
                        zombie.setLife(0);
                        //todo magnet
                    }
                    }
                case ("Jalapeno"):
                    if (this.getYCoordinate() == zombie.getY() ) {
                        zombie.setLife(0);
                    }
            }
            //todo finishingmineZombie except magnet

        }
    }
}
